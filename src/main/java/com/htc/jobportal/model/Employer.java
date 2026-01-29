package com.htc.jobportal.model;



import jakarta.persistence.*;

@Entity
@Table(name = "employer")
public class Employer extends User{
    
    @Id
    @Column(name = "user_id")
    private Long userId;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "industry")
    private String industry;
    
    @Column(name = "location")
    private String location;
    
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private java.util.List<Job> jobs;
    
    // Constructors
    public Employer() {}
    
    public Employer(User user, String companyName, String industry, String location) {
        this.user = user;
        this.userId = user.getUserId();
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
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
        this.userId = user.getUserId();
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
    
    public java.util.List<Job> getJobs() {
        return jobs;
    }
    
    public void setJobs(java.util.List<Job> jobs) {
        this.jobs = jobs;
    }
}
