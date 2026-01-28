package com.htc.jobportal.dto;

public class JobSeekerRequestDTO {
    private Long userId;
    private String skills;
    private String resumeUrl;
    private Integer experienceYears;
    
    // Constructors
    public JobSeekerRequestDTO() {}
    
    public JobSeekerRequestDTO(Long userId, String skills, String resumeUrl, Integer experienceYears) {
        this.userId = userId;
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
}
