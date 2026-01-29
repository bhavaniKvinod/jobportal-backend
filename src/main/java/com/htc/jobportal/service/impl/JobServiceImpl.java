package com.htc.jobportal.service.impl;

import com.htc.jobportal.exception.ResourceNotFoundException;
import com.htc.jobportal.model.Job;
import com.htc.jobportal.repository.JobRepository;
import com.htc.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    
    @Autowired
    private JobRepository jobRepository;
    
    @Override
    public Job createJob(Job job) {
        job.setPostedDate(LocalDate.now());
        return jobRepository.save(job);
    }
    
    @Override
    public Optional<Job> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }
    
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    @Override
    public List<Job> getJobsByEmployerId(Long employerUserId) {
        return jobRepository.findByEmployerUserId(employerUserId);
    }
    
    @Override
    public List<Job> getJobsByStatus(String status) {
        return jobRepository.findByStatus(status);
    }
    
    @Override
    public Job updateJob(Long jobId, Job job) {
        Job jobToUpdate = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));
        
        jobToUpdate.setTitle(job.getTitle());
        jobToUpdate.setDescription(job.getDescription());
        jobToUpdate.setJobType(job.getJobType());
        jobToUpdate.setRequirements(job.getRequirements());
        jobToUpdate.setSalaryRange(job.getSalaryRange());
        jobToUpdate.setStatus(job.getStatus());
        return jobRepository.save(jobToUpdate);
    }
    
    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
