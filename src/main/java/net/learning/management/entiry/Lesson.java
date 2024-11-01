package net.learning.management.entiry;

import lombok.Data;

@Data
public class Lesson {
    private Long id;
    private Long courseId;       // links to the Course entity
    private String title;
    private String content;
    private int order;           // Order in the course sequence
    private String videoUrl;
}

