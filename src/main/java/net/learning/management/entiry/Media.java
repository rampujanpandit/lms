package net.learning.management.entiry;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Media {
    private Long id;
    private String fileName;
    private String mediaType;     // Media type, e.g., "video", "pdf"
    private String url;           // URL or file path
    private LocalDateTime uploadDate;
}

