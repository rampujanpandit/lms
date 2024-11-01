package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Comment;
import net.learning.management.repo.CommentDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentDAO commentDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public int addComment(Comment comment) {
        comment.setCommentedAt(LocalDateTime.now());
        return commentDAO.save(comment);
    }

    public List<Comment> getCommentsByForumPostId(Long forumPostId) {
        return commentDAO.findByForumPostId(forumPostId);
    }
}

