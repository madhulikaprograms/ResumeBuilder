package com.sefaunal.resumebuilder.Service;

import com.sefaunal.resumebuilder.Exception.PasswordException;
import com.sefaunal.resumebuilder.Model.Project;
import com.sefaunal.resumebuilder.Repository.ProjectRepository;
import com.sefaunal.resumebuilder.Request.ProjectRequest;
import com.sefaunal.resumebuilder.Utils.CommonUtils;
import com.sefaunal.resumebuilder.Utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Collection;
import java.util.Objects;

/**
 * @author github.com/sefaunal
 * @since 2024-01-23
 */
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
     public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(Project project, MultipartFile projectImage, String userId) {
        String uniqueFilename = ImageUtils.generateUniqueFilename(
                CommonUtils.getUserInfo(),
                Objects.requireNonNull(projectImage.getContentType())
        );
        String imageURI = ImageUtils.firebaseUploadImage(projectImage, uniqueFilename);

        project.setUserId(userId);
        project.setImageURI(imageURI);
        project.setAdditionDate(Instant.now());

        projectRepository.save(project);
    }

    public Project findRecordByID(String id) {
        return projectRepository.findByID(id).orElseThrow();
    }

    public Collection<Project> findAllProjectsByUserID(String userId) {
        return projectRepository.findAllByUserID(userId);
    }

    public void deleteRecordByID(String projectId, String userId) {
        Project project = projectRepository.findByID(projectId).orElseThrow();

        if (!project.getUserId().equals(userId)) {
            throw new AccessDeniedException("IDs Don't Match. You Are Not Authorized!");
        }

        projectRepository.deleteById(projectId);
    }

    public void updateRecordByID(ProjectRequest projectRequest, MultipartFile projectImage, String userPassword, String userId) {
        Project project = projectRepository.findByID(projectRequest.getId()).orElseThrow();

        if (!project.getUserId().equals(userId)) {
            throw new AccessDeniedException("IDs Don't Match. You Are Not Authorized!");
        }

        if (!CommonUtils.checkPasswordsMatch(projectRequest.getPassword(), userPassword)) {
            throw new PasswordException("Passwords Do Not Match");
        }

        if (!projectImage.isEmpty()) {
            String uniqueFilename = ImageUtils.generateUniqueFilename(
                    CommonUtils.getUserInfo(),
                    Objects.requireNonNull(projectImage.getContentType())
            );

            String imageURI = ImageUtils.firebaseUploadImage(projectImage, uniqueFilename);
            project.setImageURI(imageURI);
        }

        project.setTitle(projectRequest.getTitle());
        project.setDescription(projectRequest.getDescription());

        projectRepository.save(project);
    }
}
