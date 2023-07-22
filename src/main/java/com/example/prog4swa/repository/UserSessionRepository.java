package com.example.prog4swa.repository;

import com.example.prog4swa.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository  extends JpaRepository<UserSession, Integer> {
    UserSession findBySessionId(String sessionId);
}
