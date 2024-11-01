package net.learning.management.entiry;

import lombok.Data;

@Data
public class Permission {
    private Long id;
    private String name;                 // e.g., "VIEW_COURSES", "EDIT_COURSES"
    private String description;
}
