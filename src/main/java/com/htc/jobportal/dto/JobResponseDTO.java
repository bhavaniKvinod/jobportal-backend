package com.htc.jobportal.dto;

import java.time.LocalDate;
import java.util.List;

public class JobResponseDTO {
    
    private Long jobId;
    private Long employerId;
    private String employerName;
    private String employerCompanyName;
    private String title;
    private String description;
    private String jobType;
    private String requirements;
    private String salaryRange;
    private String status;
    private LocalDate postedDate;
    private List<Long> applicationIds;
    
    public JobResponseDTO() {}
    
    public JobResponseDTO(Long jobId, Long employerId, String employerName, String employerCompanyName,
                         String title, String description, String jobType, String requirements,
                         String salaryRange, String status, LocalDate postedDate) {
        this.jobId = jobId;
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerCompanyName = employerCompanyName;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.requirements = requirements;
        this.salaryRange = salaryRange;
        this.status = status;
        this.postedDate = postedDate;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public Long getEmployerId() {
        return employerId;
    }
    
    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }
    
    public String getEmployerName() {
        return employerName;
    }
    
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    public String getEmployerCompanyName() {
        return employerCompanyName;
    }
    
    public void setEmployerCompanyName(String employerCompanyName) {
        this.employerCompanyName = employerCompanyName;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getJobType() {
        return jobType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    public String getRequirements() {
        return requirements;
    }
    
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    
    public String getSalaryRange() {
        return salaryRange;
    }
    
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getPostedDate() {
        return postedDate;
    }
    
    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
    
    public List<Long> getApplicationIds() {
        return applicationIds;
    }
    
    public void setApplicationIds(List<Long> applicationIds) {
        this.applicationIds = applicationIds;
    }
}
