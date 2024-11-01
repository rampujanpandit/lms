package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Comment;
import net.learning.management.serviceImpl.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        int result = commentService.addComment(comment);
        return result == 1 ? ResponseEntity.ok("Comment added successfully") : ResponseEntity.status(500).body("Failed to add comment");
    }

    @GetMapping("/forum-post/{forumPostId}")
    public ResponseEntity<List<Comment>> getCommentsByForumPostId(@PathVariable Long forumPostId) {
        return ResponseEntity.ok(commentService.getCommentsByForumPostId(forumPostId));
    }
}
