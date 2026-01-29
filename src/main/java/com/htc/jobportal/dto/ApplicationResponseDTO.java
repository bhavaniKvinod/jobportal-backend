package com.htc.jobportal.dto;

import java.time.LocalDate;
import java.util.List;

public class ApplicationResponseDTO {
    
    private Long appId;
    private Long seekerId;
    private String seekerName;
    private String seekerEmail;
    private Long jobId;
    private String jobTitle;
    private String status;
    private LocalDate appliedDate;
    private List<Long> interviewIds;
    
    public ApplicationResponseDTO() {}
    
    public ApplicationResponseDTO(Long appId, Long seekerId, String seekerName, String seekerEmail,
                                 Long jobId, String jobTitle, String status, LocalDate appliedDate) {
        this.appId = appId;
        this.seekerId = seekerId;
        this.seekerName = seekerName;
        this.seekerEmail = seekerEmail;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.status = status;
        this.appliedDate = appliedDate;
    }
    
    public Long getAppId() {
        return appId;
    }
    
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    
    public Long getSeekerId() {
        return seekerId;
    }
    
    public void setSeekerId(Long seekerId) {
        this.seekerId = seekerId;
    }
    
    public String getSeekerName() {
        return seekerName;
    }
    
    public void setSeekerName(String seekerName) {
        this.seekerName = seekerName;
    }
    
    public String getSeekerEmail() {
        return seekerEmail;
    }
    
    public void setSeekerEmail(String seekerEmail) {
        this.seekerEmail = seekerEmail;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDate getAppliedDate() {
        return appliedDate;
    }
    
    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
    
    public List<Long> getInterviewIds() {
        return interviewIds;
    }
    
    public void setInterviewIds(List<Long> interviewIds) {
        this.interviewIds = interviewIds;
    }
}
