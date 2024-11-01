package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Comment;
import net.learning.management.repo.CommentDAO;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Comment comment) {
        String sql = "INSERT INTO comment (forum_post_id, user_id, comment_text, commented_at) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, comment.getForumPostId(), comment.getUserId(), comment.getCommentText(), comment.getCommentedAt());
    }

    @Override
    public List<Comment> findByForumPostId(Long forumPostId) {
        String sql = "SELECT * FROM comment WHERE forum_post_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), forumPostId);
    }
}

