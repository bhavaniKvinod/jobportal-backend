package com.htc.jobportal.service;

import com.htc.jobportal.model.Application;
import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application createApplication(Application application);
    Optional<Application> getApplicationById(Long appId);
    List<Application> getAllApplications();
    List<Application> getApplicationsByJobSeekerId(Long jobSeekerUserId);
    List<Application> getApplicationsByJobId(Long jobId);
    List<Application> getApplicationsByStatus(String status);
    Application updateApplication(Long appId, Application application);
    void deleteApplication(Long appId);
}
