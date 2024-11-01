package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.ResearchReview;

public interface ResearchReviewDAO {
    int save(ResearchReview researchReview);
    List<ResearchReview> findByResearchPaperId(Long researchPaperId);
}

