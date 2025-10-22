package com.sefaunal.resumebuilder.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document
public class Skill {

    @Id
    private String id;

    private String skillName;
    private String skillType;
    private Instant additionDate;
    private String userId;

    // ✅ Explicit methods to avoid symbol errors
    public String getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public Instant getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(Instant additionDate) {
        this.additionDate = additionDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
