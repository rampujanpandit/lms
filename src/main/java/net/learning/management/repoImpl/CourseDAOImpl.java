package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Course;
import net.learning.management.repo.CourseDAO;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Course course) {
        String sql = "INSERT INTO courses (title, description, category, instructor_id, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getCategory(), course.getInstructorId(), course.getCreatedAt(), course.getUpdatedAt());
    }

    @Override
    public Course findById(Long id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), id);
    }

    @Override
    public List<Course> findAll() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
    }
}
