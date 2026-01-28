package com.htc.jobportal.service;

import com.htc.jobportal.model.Job;
import java.util.List;
import java.util.Optional;

public interface JobService {
    Job createJob(Job job);
    Optional<Job> getJobById(Long jobId);
    List<Job> getAllJobs();
    List<Job> getJobsByEmployerId(Long employerUserId);
    List<Job> getJobsByStatus(String status);
    Job updateJob(Long jobId, Job job);
    void deleteJob(Long jobId);
}
