package com.htc.jobportal.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EmployerResponseDTO {
    
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String companyName;
    private String industry;
    private String location;
    private List<Long> jobIds;
    
    public EmployerResponseDTO() {}
    
    public EmployerResponseDTO(Long userId, String firstName, String lastName, String email,
                              String address, String role, LocalDateTime createdAt, LocalDateTime updatedAt,
                              String companyName, String industry, String location) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.companyName = companyName;
        this.industry = industry;
        this.location = location;
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
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getIndustry() {
        return industry;
    }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<Long> getJobIds() {
        return jobIds;
    }
    
    public void setJobIds(List<Long> jobIds) {
        this.jobIds = jobIds;
    }
}
