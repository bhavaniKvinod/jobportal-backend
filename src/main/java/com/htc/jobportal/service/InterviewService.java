package com.htc.jobportal.service;

import com.htc.jobportal.model.Interview;
import java.util.List;
import java.util.Optional;

public interface InterviewService {
    Interview createInterview(Interview interview);
    Optional<Interview> getInterviewById(Long interviewId);
    List<Interview> getAllInterviews();
    List<Interview> getInterviewsByApplicationId(Long appId);
    Interview updateInterview(Long interviewId, Interview interview);
    void deleteInterview(Long interviewId);
}
