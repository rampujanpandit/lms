package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Course {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Long instructorId;  // links to the User entity (Instructor)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
