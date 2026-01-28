package com.htc.jobportal.repository;

import com.htc.jobportal.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByJwtToken(String jwtToken);
    List<Token> findByUserId(Long userId);
}
