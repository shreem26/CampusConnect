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

    @Autowired
    private StudentService studentService;

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

        // Generate random token for verification
        String token = UUID.randomUUID().toString();
        student.setVerificationToken(token);
        student.setVerified(false);

        // Save student in DB
        sr.save(student);

        // For now: print verification link in console
        System.out.println("Verification link: http://localhost:8080/auth/verify?token=" + token);

        // In real app → you'd send this link by email
        return "Signup successful! Please check your email to verify.";
    }

    public boolean verifyEmail(String token) {
        Optional<Student> studentOpt = sr.findByVerificationToken(token);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setVerified(true);
            student.setVerificationToken(null); // token no longer needed
            sr.save(student);
            return true;
        }
        return false;
    }
    public boolean login(String email, String password){
        Optional<Student> studentOpt = sr.findByEmail(email);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();

            // Check password and verification
            if (student.isVerified() && student.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/search")
    public List<Student> searchBySubject(@RequestParam String subject) {
        return studentService.searchBySubject(subject);

    }

}
