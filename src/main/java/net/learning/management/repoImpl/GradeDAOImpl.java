package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Grade;
import net.learning.management.repo.GradeDAO;

@Repository
public class GradeDAOImpl implements GradeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GradeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Grade grade) {
        String sql = "INSERT INTO grade (user_id, quiz_id, marks_obtained) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, grade.getUserId(), grade.getQuizId(), grade.getMarksObtained());
    }

    @Override
    public Grade findByUserIdAndQuizId(Long userId, Long quizId) {
        String sql = "SELECT * FROM grade WHERE user_id = ? AND quiz_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), userId, quizId);
    }
}

