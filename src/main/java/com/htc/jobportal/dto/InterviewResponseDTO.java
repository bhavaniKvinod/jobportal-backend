package com.htc.jobportal.dto;

import java.time.LocalDate;

public class InterviewResponseDTO {
    
    private Long interviewId;
    private Long applicationId;
    private String applicationStatus;
    private String mode;
    private LocalDate scheduledDate;
    private String result;
    private String feedback;
    
    public InterviewResponseDTO() {}
    
    public InterviewResponseDTO(Long interviewId, Long applicationId, String applicationStatus,
                               String mode, LocalDate scheduledDate, String result, String feedback) {
        this.interviewId = interviewId;
        this.applicationId = applicationId;
        this.applicationStatus = applicationStatus;
        this.mode = mode;
        this.scheduledDate = scheduledDate;
        this.result = result;
        this.feedback = feedback;
    }
    
    public Long getInterviewId() {
        return interviewId;
    }
    
    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }
    
    public Long getApplicationId() {
        return applicationId;
    }
    
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    public String getApplicationStatus() {
        return applicationStatus;
    }
    
    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public LocalDate getScheduledDate() {
        return scheduledDate;
    }
    
    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public String getFeedback() {
        return feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
