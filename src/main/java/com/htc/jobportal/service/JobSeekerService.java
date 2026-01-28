package com.htc.jobportal.service;

import com.htc.jobportal.model.JobSeeker;
import java.util.List;
import java.util.Optional;

public interface JobSeekerService {
    JobSeeker createJobSeeker(JobSeeker jobSeeker);
    Optional<JobSeeker> getJobSeekerById(Long userId);
    List<JobSeeker> getAllJobSeekers();
    JobSeeker updateJobSeeker(Long userId, JobSeeker jobSeeker);
    void deleteJobSeeker(Long userId);
}
