package com.htc.jobportal.repository;

import com.htc.jobportal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByEmployerUserId(Long employerUserId);
    List<Job> findByStatus(String status);
}
