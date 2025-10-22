package com.sefaunal.resumebuilder.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author github.com/sefaunal
 * @since 2024-01-23
 */
@Data
@Document
public class Experience {

    @Id
    private String id; // ✅ Renamed from "ID" to "id"

    private String company;
    private String location;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String description;
    private String userId; // ✅ Renamed from "userID" to "userId"
    private Instant additionDate;
    private String formattedStartDate;
    private String formattedEndDate;

    // ✅ Explicit getters and setters to resolve service-layer errors

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Instant getAdditionDate() {
        return additionDate;
    }

    public void setAdditionDate(Instant additionDate) {
        this.additionDate = additionDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormattedStartDate() {
        return formattedStartDate;
    }

    public String getFormattedEndDate() {
        return formattedEndDate;
    }

    public void setFormattedEndDate(String formattedEndDate) {
        this.formattedEndDate = formattedEndDate;
    }

    public void formatStartDate(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM yyyy");
        this.formattedStartDate = outputFormat.format(date);
    }

    public void formatEndDate(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM yyyy");
        this.formattedEndDate = outputFormat.format(date);
    }
}
