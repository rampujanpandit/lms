package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.UserProgress;
import net.learning.management.repo.UserProgressDAO;

import java.util.List;

@Repository
public class UserProgressDAOImpl implements UserProgressDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserProgressDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(UserProgress userProgress) {
        String sql = "INSERT INTO user_progress (user_id, course_id, progress_percentage, last_accessed) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, userProgress.getUserId(), userProgress.getCourseId(), userProgress.getProgressPercentage(), userProgress.getLastAccessed());
    }

    @Override
    public UserProgress findByUserIdAndCourseId(Long userId, Long courseId) {
        String sql = "SELECT * FROM user_progress WHERE user_id = ? AND course_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserProgress.class), userId, courseId);
    }

    @Override
    public List<UserProgress> findByCourseId(Long courseId) {
        String sql = "SELECT * FROM user_progress WHERE course_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserProgress.class), courseId);
    }
}
