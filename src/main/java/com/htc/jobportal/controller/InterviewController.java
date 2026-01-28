package com.htc.jobportal.controller;

import com.htc.jobportal.model.Interview;
import com.htc.jobportal.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/interviews")
public class InterviewController {
    
    @Autowired
    private InterviewService interviewService;
    
    @PostMapping
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview) {
        Interview createdInterview = interviewService.createInterview(interview);
        return new ResponseEntity<>(createdInterview, HttpStatus.CREATED);
    }
    
    @GetMapping("/{interviewId}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long interviewId) {
        Optional<Interview> interview = interviewService.getInterviewById(interviewId);
        return interview.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviews = interviewService.getAllInterviews();
        return new ResponseEntity<>(interviews, HttpStatus.OK);
    }
    
    @GetMapping("/application/{appId}")
    public ResponseEntity<List<Interview>> getInterviewsByApplicationId(@PathVariable Long appId) {
        List<Interview> interviews = interviewService.getInterviewsByApplicationId(appId);
        return new ResponseEntity<>(interviews, HttpStatus.OK);
    }
    
    @PutMapping("/{interviewId}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long interviewId, @RequestBody Interview interview) {
        Interview updatedInterview = interviewService.updateInterview(interviewId, interview);
        if (updatedInterview != null) {
            return new ResponseEntity<>(updatedInterview, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{interviewId}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long interviewId) {
        interviewService.deleteInterview(interviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
