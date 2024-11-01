package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.ResearchPaper;
import net.learning.management.repo.ResearchPaperDAO;

import java.util.List;

@Repository
public class ResearchPaperDAOImpl implements ResearchPaperDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResearchPaperDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(ResearchPaper researchPaper) {
        String sql = "INSERT INTO research_paper (author_id, title, abstract_text, paper_url, published_date, status) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, researchPaper.getAuthorId(), researchPaper.getTitle(), researchPaper.getAbstractText(), researchPaper.getPaperUrl(), researchPaper.getPublishedDate(), researchPaper.getStatus());
    }

    @Override
    public ResearchPaper findById(Long id) {
        String sql = "SELECT * FROM research_paper WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ResearchPaper.class), id);
    }

    @Override
    public List<ResearchPaper> findByStatus(String status) {
        String sql = "SELECT * FROM research_paper WHERE status = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResearchPaper.class), status);
    }

    @Override
    public List<ResearchPaper> findByCategory(Long categoryId) {
        String sql = "SELECT rp.* FROM research_paper rp JOIN research_category rc ON rp.category_id = rc.id WHERE rc.id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ResearchPaper.class), categoryId);
    }
}

