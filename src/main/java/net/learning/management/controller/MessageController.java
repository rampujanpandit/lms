package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Message;
import net.learning.management.serviceImpl.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam String messageText) {
        int result = messageService.sendMessage(senderId, receiverId, messageText);
        return result == 1 ? ResponseEntity.ok("Message sent successfully") : ResponseEntity.status(500).body("Failed to send message");
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesByReceiverId(@PathVariable Long receiverId) {
        return ResponseEntity.ok(messageService.getMessagesByReceiverId(receiverId));
    }
}

