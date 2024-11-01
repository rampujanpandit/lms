package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.ResearchReview;
import net.learning.management.repo.ResearchReviewDAO;

import java.util.List;

@Repository
public class ResearchReviewDAOImpl implements ResearchReviewDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResearchReviewDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(ResearchReview researchReview) {
        String sql = "INSERT INTO research_review (research_paper_id, reviewer_id, rating, comments, review_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, researchReview.getResearchPaperId(), researchReview.getReviewerId(), researchReview.getRating(), researchReview.getComments(), researchReview.getReviewDate());
    }

    @Override
    public List<ResearchReview> findByResearchPaperId(Long researchPaperId) {
        String sql = "SELECT * FROM research_review WHERE research_paper_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResearchReview.class), researchPaperId);
    }
}

