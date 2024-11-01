package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResearchReview {
    private Long id;
    private Long researchPaperId;      // Reference to ResearchPaper entity
    private Long reviewerId;           // Reference to User entity (reviewer)
    private int rating;                // Rating out of 5
    private String comments;
    private LocalDateTime reviewDate;
}
