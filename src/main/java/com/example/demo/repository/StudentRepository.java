package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);

    // find student by verification token
    Optional<Student> findByVerificationToken(String token);
    Optional<Student> findByName(String name);

    // ✅ Add this line
    List<Student> findByStrongSubjectsContainingIgnoreCase(String subject);
}
