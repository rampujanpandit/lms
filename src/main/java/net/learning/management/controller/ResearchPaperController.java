package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.ResearchPaper;
import net.learning.management.serviceImpl.ResearchPaperService;

import java.util.List;

@RestController
@RequestMapping("/api/research-papers")
public class ResearchPaperController {
    private final ResearchPaperService researchPaperService;

    @Autowired
    public ResearchPaperController(ResearchPaperService researchPaperService) {
        this.researchPaperService = researchPaperService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishResearchPaper(@RequestBody ResearchPaper researchPaper) {
        int result = researchPaperService.publishResearchPaper(researchPaper);
        return result == 1 ? ResponseEntity.ok("Research paper published successfully") : ResponseEntity.status(500).body("Failed to publish research paper");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResearchPaper> getResearchPaperById(@PathVariable Long id) {
        return ResponseEntity.ok(researchPaperService.getResearchPaperById(id));
    }

    @GetMapping("/status/published")
    public ResponseEntity<List<ResearchPaper>> getPublishedResearchPapers() {
        return ResponseEntity.ok(researchPaperService.getPublishedResearchPapers());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ResearchPaper>> getResearchPapersByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(researchPaperService.getResearchPapersByCategory(categoryId));
    }
}

