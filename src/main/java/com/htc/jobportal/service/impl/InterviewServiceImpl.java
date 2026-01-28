package com.htc.jobportal.service.impl;

import com.htc.jobportal.model.Interview;
import com.htc.jobportal.repository.InterviewRepository;
import com.htc.jobportal.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {
    
    @Autowired
    private InterviewRepository interviewRepository;
    
    @Override
    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }
    
    @Override
    public Optional<Interview> getInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId);
    }
    
    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
    
    @Override
    public List<Interview> getInterviewsByApplicationId(Long appId) {
        return interviewRepository.findByApplicationAppId(appId);
    }
    
    @Override
    public Interview updateInterview(Long interviewId, Interview interview) {
        Optional<Interview> existingInterview = interviewRepository.findById(interviewId);
        if (existingInterview.isPresent()) {
            Interview interviewToUpdate = existingInterview.get();
            interviewToUpdate.setMode(interview.getMode());
            interviewToUpdate.setScheduledDate(interview.getScheduledDate());
            interviewToUpdate.setResult(interview.getResult());
            interviewToUpdate.setFeedback(interview.getFeedback());
            return interviewRepository.save(interviewToUpdate);
        }
        return null;
    }
    
    @Override
    public void deleteInterview(Long interviewId) {
        interviewRepository.deleteById(interviewId);
    }
}
