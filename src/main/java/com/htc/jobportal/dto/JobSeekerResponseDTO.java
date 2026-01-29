package com.htc.jobportal.dto;

import java.time.LocalDateTime;
import java.util.List;

public class JobSeekerResponseDTO {
    
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String skills;
    private String resumeUrl;
    private Integer experienceYears;
    private List<Long> applicationIds;
    
    public JobSeekerResponseDTO() {}
    
    public JobSeekerResponseDTO(Long userId, String firstName, String lastName, String email,
                               String address, String role, LocalDateTime createdAt, LocalDateTime updatedAt,
                               String skills, String resumeUrl, Integer experienceYears) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.skills = skills;
        this.resumeUrl = resumeUrl;
        this.experienceYears = experienceYears;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
    
    public List<Long> getApplicationIds() {
        return applicationIds;
    }
    
    public void setApplicationIds(List<Long> applicationIds) {
        this.applicationIds = applicationIds;
    }
}
