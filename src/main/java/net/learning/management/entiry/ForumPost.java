package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ForumPost {
    private Long id;
    private Long userId;          // Reference to User entity (post author)
    private Long courseId;        // Reference to Course entity
    private String title;
    private String content;
    private LocalDateTime postedAt;
}

