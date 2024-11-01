package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.CourseStats;
import net.learning.management.serviceImpl.CourseStatsService;

@RestController
@RequestMapping("/api/course-stats")
public class CourseStatsController {
    private final CourseStatsService courseStatsService;

    @Autowired
    public CourseStatsController(CourseStatsService courseStatsService) {
        this.courseStatsService = courseStatsService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseStats> getCourseStats(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseStatsService.getCourseStats(courseId));
    }

    @PutMapping("/update-enrollment")
    public ResponseEntity<String> updateEnrollmentCount(@RequestParam Long courseId, @RequestParam int enrollmentCount) {
        int result = courseStatsService.updateEnrollmentCount(courseId, enrollmentCount);
        return result == 1 ? ResponseEntity.ok("Enrollment count updated") : ResponseEntity.status(500).body("Failed to update enrollment count");
    }

    @PutMapping("/update-completion")
    public ResponseEntity<String> updateCompletionCount(@RequestParam Long courseId, @RequestParam int completionCount) {
        int result = courseStatsService.updateCompletionCount(courseId, completionCount);
        return result == 1 ? ResponseEntity.ok("Completion count updated") : ResponseEntity.status(500).body("Failed to update completion count");
    }

    @PutMapping("/update-rating")
    public ResponseEntity<String> updateAverageRating(@RequestParam Long courseId, @RequestParam double averageRating) {
        int result = courseStatsService.updateAverageRating(courseId, averageRating);
        return result == 1 ? ResponseEntity.ok("Average rating updated") : ResponseEntity.status(500).body("Failed to update rating");
    }
}
