package com.htc.jobportal.dto;

public class EmployerRequestDTO {
    private Long userId;
    private String companyName;
    private String industry;
    private String location;
    
    // Constructors
    public EmployerRequestDTO() {}
    
    public EmployerRequestDTO(Long userId, String companyName, String industry, String location) {
        this.userId = userId;
        this.companyName = companyName;
        this.industry = industry;
        this.location = location;
    }
    
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
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
}
