package com.htc.jobportal.controller;

import com.htc.jobportal.model.JobSeeker;
import com.htc.jobportal.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job-seekers")
public class JobSeekerController {
    
    @Autowired
    private JobSeekerService jobSeekerService;
    
    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        JobSeeker createdJobSeeker = jobSeekerService.createJobSeeker(jobSeeker);
        return new ResponseEntity<>(createdJobSeeker, HttpStatus.CREATED);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long userId) {
        Optional<JobSeeker> jobSeeker = jobSeekerService.getJobSeekerById(userId);
        return jobSeeker.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable Long userId, @RequestBody JobSeeker jobSeeker) {
        JobSeeker updatedJobSeeker = jobSeekerService.updateJobSeeker(userId, jobSeeker);
        if (updatedJobSeeker != null) {
            return new ResponseEntity<>(updatedJobSeeker, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long userId) {
        jobSeekerService.deleteJobSeeker(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
