package net.learning.management.entiry;

import lombok.Data;

@Data
public class InstructorStats {
    private Long id;
    private Long instructorId;          // Reference to User entity (instructor)
    private int coursesTaught;          // Number of courses taught by the instructor
    private int totalStudents;          // Total number of students taught by the instructor
    private double averageRating;       // Average rating across courses taught by the instructor
}

