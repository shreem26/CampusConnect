package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sr;

    public Student saveStudent(Student student) {
        return sr.save(student);
    }

    public List<Student> getAllStudents() {
        return sr.findAll();
    }

    public void deleteStudent(Student student) {
        sr.delete(student);
    }

    public Student findStudentById(Integer id) {
        return sr.findById(id).orElse(null);
    }

    public Student findStudentByName(String name) {
        return sr.findByName(name).orElse(null);
    }

    public String registerStudent(Student student) {
        Optional<Student> existing = sr.findByEmail(student.getEmail());
        if (existing.isPresent()) {
            return "Email already registered!";
        }

        String token = UUID.randomUUID().toString();
        student.setVerificationToken(token);
        student.setVerified(false);
        sr.save(student);

        System.out.println("Verification link: http://localhost:8080/auth/verify?token=" + token);

        return "Signup successful! Please check your email to verify.";
    }

    public boolean verifyEmail(String token) {
        Optional<Student> studentOpt = sr.findByVerificationToken(token);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setVerified(true);
            student.setVerificationToken(null);
            sr.save(student);
            return true;
        }
        return false;
    }

    public boolean login(String email, String password) {
        Optional<Student> studentOpt = sr.findByEmail(email);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            return student.isVerified() && student.getPassword().equals(password);
        }
        return false;
    }

    // ✅ New method for searching tutors/students by subject
    public List<Student> searchBySubject(String subject) {
        return sr.findByStrongSubjectsContainingIgnoreCase(subject);
    }

}
