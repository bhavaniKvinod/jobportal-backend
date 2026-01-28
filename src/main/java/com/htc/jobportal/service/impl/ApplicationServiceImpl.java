package com.htc.jobportal.service.impl;

import com.htc.jobportal.model.Application;
import com.htc.jobportal.repository.ApplicationRepository;
import com.htc.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Override
    public Application createApplication(Application application) {
        application.setAppliedDate(LocalDate.now());
        return applicationRepository.save(application);
    }
    
    @Override
    public Optional<Application> getApplicationById(Long appId) {
        return applicationRepository.findById(appId);
    }
    
    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    
    @Override
    public List<Application> getApplicationsByJobSeekerId(Long jobSeekerUserId) {
        return applicationRepository.findByJobSeekerUserId(jobSeekerUserId);
    }
    
    @Override
    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobJobId(jobId);
    }
    
    @Override
    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }
    
    @Override
    public Application updateApplication(Long appId, Application application) {
        Optional<Application> existingApplication = applicationRepository.findById(appId);
        if (existingApplication.isPresent()) {
            Application appToUpdate = existingApplication.get();
            appToUpdate.setStatus(application.getStatus());
            return applicationRepository.save(appToUpdate);
        }
        return null;
    }
    
    @Override
    public void deleteApplication(Long appId) {
        applicationRepository.deleteById(appId);
    }
}
