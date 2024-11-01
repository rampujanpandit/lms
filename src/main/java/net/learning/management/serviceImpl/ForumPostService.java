package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.ForumPost;
import net.learning.management.repo.ForumPostDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumPostService {
    private final ForumPostDAO forumPostDAO;

    @Autowired
    public ForumPostService(ForumPostDAO forumPostDAO) {
        this.forumPostDAO = forumPostDAO;
    }

    public int addForumPost(ForumPost forumPost) {
        forumPost.setPostedAt(LocalDateTime.now());
        return forumPostDAO.save(forumPost);
    }

    public ForumPost getForumPostById(Long id) {
        return forumPostDAO.findById(id);
    }

    public List<ForumPost> getForumPostsByCourseId(Long courseId) {
        return forumPostDAO.findByCourseId(courseId);
    }
}

