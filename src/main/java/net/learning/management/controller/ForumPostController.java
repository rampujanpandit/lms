package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.ForumPost;
import net.learning.management.serviceImpl.ForumPostService;

import java.util.List;

@RestController
@RequestMapping("/api/forum-posts")
public class ForumPostController {
    private final ForumPostService forumPostService;

    @Autowired
    public ForumPostController(ForumPostService forumPostService) {
        this.forumPostService = forumPostService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addForumPost(@RequestBody ForumPost forumPost) {
        int result = forumPostService.addForumPost(forumPost);
        return result == 1 ? ResponseEntity.ok("Forum post added successfully") : ResponseEntity.status(500).body("Failed to add forum post");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumPost> getForumPostById(@PathVariable Long id) {
        ForumPost forumPost = forumPostService.getForumPostById(id);
        return forumPost != null ? ResponseEntity.ok(forumPost) : ResponseEntity.notFound().build();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ForumPost>> getForumPostsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(forumPostService.getForumPostsByCourseId(courseId));
    }
}

