package com.example.demo.repository;
import java.util.*;
import com.example.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);
}
