package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.UserProgress;
import net.learning.management.serviceImpl.UserProgressService;

import java.util.List;

@RestController
@RequestMapping("/api/user-progress")
public class UserProgressController {
    private final UserProgressService userProgressService;

    @Autowired
    public UserProgressController(UserProgressService userProgressService) {
        this.userProgressService = userProgressService;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProgress(@RequestParam Long userId, @RequestParam Long courseId, @RequestParam double progressPercentage, @RequestParam String lastAccessed) {
        int result = userProgressService.updateProgress(userId, courseId, progressPercentage, lastAccessed);
        return result == 1 ? ResponseEntity.ok("Progress updated successfully") : ResponseEntity.status(500).body("Failed to update progress");
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<UserProgress>> getProgressByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(userProgressService.getProgressByCourseId(courseId));
    }
}

