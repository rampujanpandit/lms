package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Message {
    private Long id;
    private Long senderId;        // Reference to User entity (message sender)
    private Long receiverId;      // Reference to User entity (message receiver)
    private String messageText;
    private LocalDateTime sentAt;
}

