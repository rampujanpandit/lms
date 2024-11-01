package net.learning.management.entiry;

import lombok.Data;

@Data
public class Answer {
    private Long id;
    private Long questionId;        // Reference to the Question entity
    private Long userId;            // Reference to the User entity (student)
    private String answerText;
    private boolean isCorrect;
}

