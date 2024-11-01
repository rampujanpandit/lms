package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.CourseStats;
import net.learning.management.repo.CourseStatsDAO;

@Repository
public class CourseStatsDAOImpl implements CourseStatsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseStatsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CourseStats findByCourseId(Long courseId) {
        String sql = "SELECT * FROM course_stats WHERE course_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CourseStats.class), courseId);
    }

    @Override
    public int updateEnrollmentCount(Long courseId, int enrollmentCount) {
        String sql = "UPDATE course_stats SET enrollment_count = ? WHERE course_id = ?";
        return jdbcTemplate.update(sql, enrollmentCount, courseId);
    }

    @Override
    public int updateCompletionCount(Long courseId, int completionCount) {
        String sql = "UPDATE course_stats SET completion_count = ? WHERE course_id = ?";
        return jdbcTemplate.update(sql, completionCount, courseId);
    }

    @Override
    public int updateAverageRating(Long courseId, double averageRating) {
        String sql = "UPDATE course_stats SET average_rating = ? WHERE course_id = ?";
        return jdbcTemplate.update(sql, averageRating, courseId);
    }
}

