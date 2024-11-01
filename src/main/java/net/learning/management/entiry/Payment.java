package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;
    private Long userId;            // Reference to User entity (payer)
    private Long courseId;          // Reference to Course entity (paid course)
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentStatus;    // e.g., "completed", "pending", "failed"
}
