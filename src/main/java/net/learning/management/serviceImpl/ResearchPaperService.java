package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.ResearchPaper;
import net.learning.management.repo.ResearchPaperDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResearchPaperService {
    private final ResearchPaperDAO researchPaperDAO;

    @Autowired
    public ResearchPaperService(ResearchPaperDAO researchPaperDAO) {
        this.researchPaperDAO = researchPaperDAO;
    }

    public int publishResearchPaper(ResearchPaper researchPaper) {
        researchPaper.setPublishedDate(LocalDateTime.now());
        researchPaper.setStatus("published");
        return researchPaperDAO.save(researchPaper);
    }

    public ResearchPaper getResearchPaperById(Long id) {
        return researchPaperDAO.findById(id);
    }

    public List<ResearchPaper> getPublishedResearchPapers() {
        return researchPaperDAO.findByStatus("published");
    }

    public List<ResearchPaper> getResearchPapersByCategory(Long categoryId) {
        return researchPaperDAO.findByCategory(categoryId);
    }
}

