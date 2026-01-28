package com.htc.jobportal.service.impl;

import com.htc.jobportal.model.JobSeeker;
import com.htc.jobportal.repository.JobSeekerRepository;
import com.htc.jobportal.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {
    
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    
    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }
    
    @Override
    public Optional<JobSeeker> getJobSeekerById(Long userId) {
        return jobSeekerRepository.findByUserId(userId);
    }
    
    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }
    
    @Override
    public JobSeeker updateJobSeeker(Long userId, JobSeeker jobSeeker) {
        Optional<JobSeeker> existingJobSeeker = jobSeekerRepository.findByUserId(userId);
        if (existingJobSeeker.isPresent()) {
            JobSeeker jobSeekerToUpdate = existingJobSeeker.get();
            jobSeekerToUpdate.setSkills(jobSeeker.getSkills());
            jobSeekerToUpdate.setResumeUrl(jobSeeker.getResumeUrl());
            jobSeekerToUpdate.setExperienceYears(jobSeeker.getExperienceYears());
            return jobSeekerRepository.save(jobSeekerToUpdate);
        }
        return null;
    }
    
    @Override
    public void deleteJobSeeker(Long userId) {
        jobSeekerRepository.deleteById(userId);
    }
}
