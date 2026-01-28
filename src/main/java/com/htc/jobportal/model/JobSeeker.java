package com.htc.jobportal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User {
    
    @Id
    @Column(name = "user_id")
    private Long userId;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "skills")
    private String skills;
    
    @Column(name = "resume_url")
    private String resumeUrl;
    
    @Column(name = "exp_years", nullable = false)
    private Integer experienceYears;
    
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private java.util.List<Application> applications;
    
    // Constructors
    public JobSeeker() {}
    
    public JobSeeker(User user, String skills, String resumeUrl, Integer experienceYears) {
        this.user = user;
        this.userId = user.getUserId();
        this.skills = skills;
        this.resumeUrl = resumeUrl;
        this.experienceYears = experienceYears;
    }
    
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
        this.userId = user.getUserId();
    }
    
    public String getSkills() {
        return skills;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public String getResumeUrl() {
        return resumeUrl;
    }
    
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
    
    public Integer getExperienceYears() {
        return experienceYears;
    }
    
    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
    
    public java.util.List<Application> getApplications() {
        return applications;
    }
    
    public void setApplications(java.util.List<Application> applications) {
        this.applications = applications;
    }
}
