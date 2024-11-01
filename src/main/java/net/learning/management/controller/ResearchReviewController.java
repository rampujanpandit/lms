package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.ResearchReview;
import net.learning.management.serviceImpl.ResearchReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/research-reviews")
public class ResearchReviewController {
    private final ResearchReviewService researchReviewService;

    @Autowired
    public ResearchReviewController(ResearchReviewService researchReviewService) {
        this.researchReviewService = researchReviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody ResearchReview review) {
        int result = researchReviewService.addReview(review);
        return result == 1 ? ResponseEntity.ok("Review added successfully") : ResponseEntity.status(500).body("Failed to add review");
    }

    @GetMapping("/paper/{researchPaperId}")
    public ResponseEntity<List<ResearchReview>> getReviewsByResearchPaperId(@PathVariable Long researchPaperId) {
        return ResponseEntity.ok(researchReviewService.getReviewsByResearchPaperId(researchPaperId));
    }
}

