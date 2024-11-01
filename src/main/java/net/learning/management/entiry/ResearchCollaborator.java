package net.learning.management.entiry;

import lombok.Data;

@Data
public class ResearchCollaborator {
    private Long id;
    private Long researchPaperId;      // Reference to ResearchPaper entity
    private Long userId;               // Reference to User entity (collaborator)
    private String role;               // e.g., "co-author", "contributor"
}
