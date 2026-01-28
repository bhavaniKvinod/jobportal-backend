package com.htc.jobportal.service.impl;

import com.htc.jobportal.model.Employer;
import com.htc.jobportal.repository.EmployerRepository;
import com.htc.jobportal.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {
    
    @Autowired
    private EmployerRepository employerRepository;
    
    @Override
    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
    
    @Override
    public Optional<Employer> getEmployerById(Long userId) {
        return employerRepository.findByUserId(userId);
    }
    
    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
    
    @Override
    public Employer updateEmployer(Long userId, Employer employer) {
        Optional<Employer> existingEmployer = employerRepository.findByUserId(userId);
        if (existingEmployer.isPresent()) {
            Employer employerToUpdate = existingEmployer.get();
            employerToUpdate.setCompanyName(employer.getCompanyName());
            employerToUpdate.setIndustry(employer.getIndustry());
            employerToUpdate.setLocation(employer.getLocation());
            return employerRepository.save(employerToUpdate);
        }
        return null;
    }
    
    @Override
    public void deleteEmployer(Long userId) {
        employerRepository.deleteById(userId);
    }
}
