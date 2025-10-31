package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StudentService studentService;

    // 📝 Register (Signup)
    @PostMapping("/register")
    public String register(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    // ✅ Email Verification
    @GetMapping("/verify")
    public String verifyEmail(@RequestParam("token") String token) {
        boolean verified = studentService.verifyEmail(token);
        if (verified) {
            return "Email verified successfully!";
        } else {
            return "Invalid or expired token!";
        }
    }

    // 🔐 Login
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean success = studentService.login(email, password);
        if (success) {
            return "Login successful!";
        } else {
            return "Invalid credentials or email not verified!";
        }
    }
}
