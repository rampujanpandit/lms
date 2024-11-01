package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResearchPaper {
    private Long id;
    private Long authorId;          // Reference to User entity (author)
    private String title;
    private String abstractText;
    private String paperUrl;        // URL to the uploaded paper
    private LocalDateTime publishedDate;
    private String status;          // e.g., "draft", "published"
}

