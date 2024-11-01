package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Quiz {
    private Long id;
    private Long courseId;         // Reference to the Course entity
    private String title;
    private int totalMarks;
    private LocalDateTime createdAt;
}

