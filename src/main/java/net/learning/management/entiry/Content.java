package net.learning.management.entiry;

import lombok.Data;

@Data
public class Content {
    private Long id;
    private Long lessonId;        // Reference to the Lesson entity
    private String type;          // Content type, e.g., "video", "pdf", "text"
    private String contentUrl;    // URL or path to the content
}

