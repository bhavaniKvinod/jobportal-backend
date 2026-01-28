package com.htc.jobportal.repository;

import com.htc.jobportal.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJobSeekerUserId(Long jobSeekerUserId);
    List<Application> findByJobJobId(Long jobId);
    List<Application> findByStatus(String status);
}
