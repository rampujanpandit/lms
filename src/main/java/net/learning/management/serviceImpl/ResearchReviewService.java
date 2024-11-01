package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.ResearchReview;
import net.learning.management.repo.ResearchReviewDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResearchReviewService {
    private final ResearchReviewDAO researchReviewDAO;

    @Autowired
    public ResearchReviewService(ResearchReviewDAO researchReviewDAO) {
        this.researchReviewDAO = researchReviewDAO;
    }

    public int addReview(ResearchReview review) {
        review.setReviewDate(LocalDateTime.now());
        return researchReviewDAO.save(review);
    }

    public List<ResearchReview> getReviewsByResearchPaperId(Long researchPaperId) {
        return researchReviewDAO.findByResearchPaperId(researchPaperId);
    }
}

