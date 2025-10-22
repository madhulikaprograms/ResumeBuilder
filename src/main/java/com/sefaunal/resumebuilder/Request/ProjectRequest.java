package com.sefaunal.resumebuilder.Request;

import lombok.Data;

@Data
public class ProjectRequest {

    private String id;
    private String title;
    private String description;
    private String password;

    // ✅ Explicit getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }
}
