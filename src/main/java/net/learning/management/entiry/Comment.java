package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Long forumPostId;     // Reference to ForumPost entity
    private Long userId;          // Reference to User entity (comment author)
    private String commentText;
    private LocalDateTime commentedAt;
}

