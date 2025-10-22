package com.sefaunal.resumebuilder.Request;

import lombok.Data;

import java.util.Date;

/**
 * @author github.com/sefaunal
 * @since 2024-01-24
 */
@Data
public class ExperienceRequest {

    private String id;           // ✅ Renamed from "ID" to "id"
    private String company;
    private String location;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String description;
    private String password;

    // ✅ Explicit getters to avoid "cannot find symbol" errors
    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }
}
