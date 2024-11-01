package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Certificate {
    private Long id;
    private Long userId;            // Reference to the User entity (student)
    private Long courseId;          // Reference to the Course entity
    private String certificateUrl;  // URL for the certificate
    private LocalDateTime issuedDate;
}

