package com.htc.jobportal.controller;

import com.htc.jobportal.model.Job;
import com.htc.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    
    @Autowired
    private JobService jobService;
    
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }
    
    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        Optional<Job> job = jobService.getJobById(jobId);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    
    @GetMapping("/employer/{employerUserId}")
    public ResponseEntity<List<Job>> getJobsByEmployerId(@PathVariable Long employerUserId) {
        List<Job> jobs = jobService.getJobsByEmployerId(employerUserId);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Job>> getJobsByStatus(@PathVariable String status) {
        List<Job> jobs = jobService.getJobsByStatus(status);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    
    @PutMapping("/{jobId}")
    public ResponseEntity<Job> updateJob(@PathVariable Long jobId, @RequestBody Job job) {
        Job updatedJob = jobService.updateJob(jobId, job);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }
    
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
