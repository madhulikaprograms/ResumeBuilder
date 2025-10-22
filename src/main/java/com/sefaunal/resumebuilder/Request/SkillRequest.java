package com.sefaunal.resumebuilder.Request;

import lombok.Data;

@Data
public class SkillRequest {

    private String id;           // ✅ Renamed from "ID"
    private String skillName;
    private String skillType;
    private String password;

    // ✅ Explicit getters
    public String getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public String getPassword() {
        return password;
    }
}
