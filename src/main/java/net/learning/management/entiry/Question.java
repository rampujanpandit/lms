package net.learning.management.entiry;

import lombok.Data;

@Data
public class Question {
    private Long id;
    private Long quizId;           // Reference to the Quiz entity
    private String questionText;
    private String questionType;    // e.g., "MCQ", "short answer"
}
