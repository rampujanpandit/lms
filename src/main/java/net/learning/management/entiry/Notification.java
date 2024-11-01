package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Notification {
    private Long id;
    private Long userId;          // Reference to User entity (notification recipient)
    private String message;
    private LocalDateTime sentAt;
    private String status;        // e.g., "seen", "unseen"
}
