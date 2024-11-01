package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.ResearchPaper;

public interface ResearchPaperDAO {
    int save(ResearchPaper researchPaper);
    ResearchPaper findById(Long id);
    List<ResearchPaper> findByStatus(String status);
    List<ResearchPaper> findByCategory(Long categoryId);
}

