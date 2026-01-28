package com.htc.jobportal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "application")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long appId;
    
    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private JobSeeker jobSeeker;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "applied_date")
    private LocalDate appliedDate;
    
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private java.util.List<Interview> interviews;
    
    // Constructors
    public Application() {}
    
    public Application(JobSeeker jobSeeker, Job job, String status) {
        this.jobSeeker = jobSeeker;
        this.job = job;
        this.status = status;
        this.appliedDate = LocalDate.now();
    }
    
    // Getters and Setters
    public Long getAppId() {
        return appId;
    }
    
    public void setAppId(Long appId) {
        this.appId = appId;
    }
    
    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }
    
    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    
    public Job getJob() {
        return job;
    }
    
    public void setJob(Job job) {
        this.job = job;
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
    
    public java.util.List<Interview> getInterviews() {
        return interviews;
    }
    
    public void setInterviews(java.util.List<Interview> interviews) {
        this.interviews = interviews;
    }
}
