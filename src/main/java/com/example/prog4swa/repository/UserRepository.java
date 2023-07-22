package com.example.prog4swa.repository;

import com.example.prog4swa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);
}
