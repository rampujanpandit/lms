package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Content;
import net.learning.management.repo.ContentDAO;

import java.util.List;

@Repository
public class ContentDAOImpl implements ContentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Content content) {
        String sql = "INSERT INTO content (lesson_id, type, content_url) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, content.getLessonId(), content.getType(), content.getContentUrl());
    }

    @Override
    public Content findById(Long id) {
        String sql = "SELECT * FROM content WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Content.class), id);
    }

    @Override
    public List<Content> findByLessonId(Long lessonId) {
        String sql = "SELECT * FROM content WHERE lesson_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Content.class), lessonId);
    }
}
