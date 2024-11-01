package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.ForumPost;
import net.learning.management.repo.ForumPostDAO;

import java.util.List;

@Repository
public class ForumPostDAOImpl implements ForumPostDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ForumPostDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(ForumPost forumPost) {
        String sql = "INSERT INTO forum_post (user_id, course_id, title, content, posted_at) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, forumPost.getUserId(), forumPost.getCourseId(), forumPost.getTitle(), forumPost.getContent(), forumPost.getPostedAt());
    }

    @Override
    public ForumPost findById(Long id) {
        String sql = "SELECT * FROM forum_post WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ForumPost.class), id);
    }

    @Override
    public List<ForumPost> findByCourseId(Long courseId) {
        String sql = "SELECT * FROM forum_post WHERE course_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ForumPost.class), courseId);
    }
}

