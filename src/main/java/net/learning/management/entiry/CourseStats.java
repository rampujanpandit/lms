package net.learning.management.entiry;

import lombok.Data;

@Data
public class CourseStats {
    private Long id;
    private Long courseId;              // Reference to Course entity
    private int enrollmentCount;        // Number of students enrolled in the course
    private int completionCount;        // Number of students who completed the course
    private double averageRating;       // Average rating of the course
}

