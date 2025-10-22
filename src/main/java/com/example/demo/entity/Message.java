package com.example.demo.entity;
import java.time.*;
import jakarta.persistence.*;

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private String senderId;
    private String receiverId;
    private LocalDate timeStamp;
    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }
}
