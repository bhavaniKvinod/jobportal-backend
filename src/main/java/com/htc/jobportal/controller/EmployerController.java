package com.htc.jobportal.controller;

import com.htc.jobportal.model.Employer;
import com.htc.jobportal.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController {
    
    @Autowired
    private EmployerService employerService;
    
    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer createdEmployer = employerService.createEmployer(employer);
        return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long userId) {
        Optional<Employer> employer = employerService.getEmployerById(userId);
        return employer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long userId, @RequestBody Employer employer) {
        Employer updatedEmployer = employerService.updateEmployer(userId, employer);
        if (updatedEmployer != null) {
            return new ResponseEntity<>(updatedEmployer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long userId) {
        employerService.deleteEmployer(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
