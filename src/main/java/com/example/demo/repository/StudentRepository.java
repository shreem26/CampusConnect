package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findByName(String name);

    // find student by email
    Optional<Student> findByEmail(String email);

    // find student by verification token
    Optional<Student> findByVerificationToken(String token);
}
