package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.ForumPost;

public interface ForumPostDAO {
    int save(ForumPost forumPost);
    ForumPost findById(Long id);
    List<ForumPost> findByCourseId(Long courseId);
}

