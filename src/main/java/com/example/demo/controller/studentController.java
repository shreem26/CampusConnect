package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private StudentService studentService;

    // ✅ Search endpoint
    @GetMapping("/search")
    public List<Student> searchBySubject(@RequestParam String subject) {
        return studentService.searchBySubject(subject);
    }
}
