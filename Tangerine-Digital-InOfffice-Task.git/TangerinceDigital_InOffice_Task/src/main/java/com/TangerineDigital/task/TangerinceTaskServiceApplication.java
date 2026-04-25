package com.TangerineDigital.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Cacheable;

@Cacheable
@SpringBootApplication
public class TangerinceTaskServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TangerinceTaskServiceApplication.class, args);
    }
}