package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Quiz;
import net.learning.management.repo.QuizDAO;

import java.util.List;

@Repository
public class QuizDAOImpl implements QuizDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuizDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Quiz quiz) {
        String sql = "INSERT INTO quiz (course_id, title, total_marks, created_at) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, quiz.getCourseId(), quiz.getTitle(), quiz.getTotalMarks(), quiz.getCreatedAt());
    }

    @Override
    public Quiz findById(Long id) {
        String sql = "SELECT * FROM quiz WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Quiz.class), id);
    }

    @Override
    public List<Quiz> findByCourseId(Long courseId) {
        String sql = "SELECT * FROM quiz WHERE course_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Quiz.class), courseId);
    }
}

