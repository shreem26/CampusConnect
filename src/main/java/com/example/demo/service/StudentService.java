package com.example.demo.service;
import java.util.*;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository sr;
    public Student saveStudent(Student student){
        return sr.save(student);
    }
    public List<Student> getAllStudent(){
        return sr.findAll();
    }
    public void deleteStudent(Student student){
        sr.delete(student);
    }
    public Student findStudentById(Integer id) {
        return sr.findById(id).orElse(null);
    }
    public Student findStudentByName(String name){
        return sr.findByName(name).orElse(null);
    }
}
