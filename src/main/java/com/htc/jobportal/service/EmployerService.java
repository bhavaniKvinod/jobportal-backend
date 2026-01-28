package com.htc.jobportal.service;

import com.htc.jobportal.model.Employer;
import java.util.List;
import java.util.Optional;

public interface EmployerService {
    Employer createEmployer(Employer employer);
    Optional<Employer> getEmployerById(Long userId);
    List<Employer> getAllEmployers();
    Employer updateEmployer(Long userId, Employer employer);
    void deleteEmployer(Long userId);
}
