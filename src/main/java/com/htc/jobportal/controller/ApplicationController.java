package com.htc.jobportal.controller;

import com.htc.jobportal.model.Application;
import com.htc.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;
    
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application createdApplication = applicationService.createApplication(application);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }
    
    @GetMapping("/{appId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long appId) {
        Optional<Application> application = applicationService.getApplicationById(appId);
        return application.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
    @GetMapping("/job-seeker/{jobSeekerUserId}")
    public ResponseEntity<List<Application>> getApplicationsByJobSeekerId(@PathVariable Long jobSeekerUserId) {
        List<Application> applications = applicationService.getApplicationsByJobSeekerId(jobSeekerUserId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJobId(@PathVariable Long jobId) {
        List<Application> applications = applicationService.getApplicationsByJobId(jobId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Application>> getApplicationsByStatus(@PathVariable String status) {
        List<Application> applications = applicationService.getApplicationsByStatus(status);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
    @PutMapping("/{appId}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long appId, @RequestBody Application application) {
        Application updatedApplication = applicationService.updateApplication(appId, application);
        if (updatedApplication != null) {
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long appId) {
        applicationService.deleteApplication(appId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
