package com.sefaunal.resumebuilder.Model;

import com.sefaunal.resumebuilder.Annotation.UniqueEmail;
import com.sefaunal.resumebuilder.Annotation.UniqueUsername;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

@Data
@Document
public class User implements UserDetails {

    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 75)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 75)
    private String lastName;

    @NotNull
    @UniqueUsername
    @Size(min = 2, max = 75)
    private String username;

    @NotNull
    @UniqueEmail
    @Size(min = 2, max = 75)
    private String email;

    @NotNull
    @Size(min = 8, max = 75)
    private String password;

    private String role;
    private String profileImageURI;
    private Instant accountCreationDate;
    private UserAboutMe aboutMe;
    private UserVisibilitySettings visibilitySettings;
    private boolean accountNonLocked;
    private boolean accountEnabled;

    // ✅ Explicit getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getProfileImageURI() { return profileImageURI; }
    public Instant getAccountCreationDate() { return accountCreationDate; }
    public UserAboutMe getAboutMe() { return aboutMe; }
    public UserVisibilitySettings getVisibilitySettings() { return visibilitySettings; }

    // ✅ Explicit setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setProfileImageURI(String profileImageURI) { this.profileImageURI = profileImageURI; }
    public void setAccountCreationDate(Instant accountCreationDate) { this.accountCreationDate = accountCreationDate; }
    public void setAboutMe(UserAboutMe aboutMe) { this.aboutMe = aboutMe; }
    public void setVisibilitySettings(UserVisibilitySettings visibilitySettings) { this.visibilitySettings = visibilitySettings; }
    public void setAccountNonLocked(boolean accountNonLocked) { this.accountNonLocked = accountNonLocked; }
    public void setAccountEnabled(boolean accountEnabled) { this.accountEnabled = accountEnabled; }

    // ✅ Required by UserDetails interface
    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return accountNonLocked; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return accountEnabled; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }
}
