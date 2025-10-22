package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String collegeId;
    private String collegeName;
    private String branch;
    private int year;
    private boolean isTutor;
    private String strongSubjects;
    //private double rating;
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setTutor(boolean tutor) {
        isTutor = tutor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStrongSubjects(String strongSubjects) {
        this.strongSubjects = strongSubjects;
    }

    public int getId() {
        return id;
    }

    public String getBranch() {
        return branch;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public int getYear() {
        return year;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getName() {
        return name;
    }

    public String getStrongSubjects() {
        return strongSubjects;
    }

    public boolean isTutor() {
        return isTutor;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
