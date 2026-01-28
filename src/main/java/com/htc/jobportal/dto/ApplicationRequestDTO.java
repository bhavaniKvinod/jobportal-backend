package com.htc.jobportal.dto;

public class ApplicationRequestDTO {
    private Long jobSeekerUserId;
    private Long jobId;
    private String status;
    
    // Constructors
    public ApplicationRequestDTO() {}
    
    public ApplicationRequestDTO(Long jobSeekerUserId, Long jobId, String status) {
        this.jobSeekerUserId = jobSeekerUserId;
        this.jobId = jobId;
        this.status = status;
    }
    
    // Getters and Setters
    public Long getJobSeekerUserId() {
        return jobSeekerUserId;
    }
    
    public void setJobSeekerUserId(Long jobSeekerUserId) {
        this.jobSeekerUserId = jobSeekerUserId;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
