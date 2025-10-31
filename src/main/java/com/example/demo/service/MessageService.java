package com.example.demo.service;
import java.util.*;
import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class MessageService {
    @Autowired
    private MessageRepository mr;
    public Message saveMessage(Message message){
        return mr.save(message);
    }
    public List<Message> getMessagesBetween(String senderId,String receiverId){
        return mr.findBySenderIdAndReceiverId(senderId,receiverId);
    }
    public List<Message> getAllMessages(){
        return mr.findAll();
    }
    public void deleteMessage(Message message){
        mr.delete(message);
    }
}
