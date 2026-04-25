package com.TangerineDigital.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TangerineDigital.model.TaskAccount;


public interface TaskRepository extends JpaRepository<TaskAccount, Long> {
    Optional<TaskAccount> findValue(int value);
 
}