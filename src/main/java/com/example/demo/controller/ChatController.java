package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    /**
     * This method is triggered when a message is sent to /app/chat
     */
    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        // Save message in DB
        messageService.saveMessage(message);

        // Send message to the receiver in real-time
        messagingTemplate.convertAndSendToUser(
                message.getReceiverId(),          // destination user
                "/queue/messages",                // destination path
                message                           // payload
        );
    }
}
