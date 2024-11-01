package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Comment;

public interface CommentDAO {
    int save(Comment comment);
    List<Comment> findByForumPostId(Long forumPostId);
}

