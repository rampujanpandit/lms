package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Subscription {
    private Long id;
    private Long userId;            // Reference to User entity (subscriber)
    private String plan;            // e.g., "monthly", "yearly"
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;          // e.g., "active", "expired"
}

