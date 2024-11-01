package net.learning.management.entiry;

import lombok.Data;

@Data
public class Grade {
    private Long id;
    private Long userId;            // Reference to the User entity (student)
    private Long quizId;            // Reference to the Quiz entity
    private int marksObtained;
}

