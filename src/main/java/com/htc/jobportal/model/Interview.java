package com.htc.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "interview")
public class Interview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private Long interviewId;
    
    @ManyToOne
    @JoinColumn(name = "app_id")
    private Application application;
    
    @Column(name = "mode")
    private String mode;
    
    @Column(name = "sched_date")
    private LocalDate scheduledDate;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "feedback")
    private String feedback;
    
    // Constructors
    public Interview() {}
    
    public Interview(Application application, String mode, LocalDate scheduledDate) {
        this.application = application;
        this.mode = mode;
        this.scheduledDate = scheduledDate;
    }
    
    // Getters and Setters
    public Long getInterviewId() {
        return interviewId;
    }
    
    public void setInterviewId(Long interviewId) {
        this.interviewId = interviewId;
    }
    
    public Application getApplication() {
        return application;
    }
    
    public void setApplication(Application application) {
        this.application = application;
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
