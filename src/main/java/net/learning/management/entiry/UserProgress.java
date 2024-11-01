package net.learning.management.entiry;

import lombok.Data;

@Data
public class UserProgress {
    private Long id;
    private Long userId;                // Reference to User entity (student)
    private Long courseId;              // Reference to Course entity
    private double progressPercentage;  // Progress in course as a percentage
    private String lastAccessed;        // Date/time when the user last accessed the course
}
