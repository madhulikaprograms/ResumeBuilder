package com.sefaunal.resumebuilder.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
public class Project {

    @Id
    private String id;

    private String title;
    private String description;
    private String imageURI;
    private Instant additionDate;
    private String userId;

    // ✅ Explicit getters
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getImageURI() {
        return imageURI;
    }

    public Instant getAdditionDate() {
        return additionDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // ✅ Explicit setters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public void setAdditionDate(Instant additionDate) {
        this.additionDate = additionDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
