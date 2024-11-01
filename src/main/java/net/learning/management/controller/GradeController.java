package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Grade;
import net.learning.management.serviceImpl.GradeService;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateGrade(@RequestParam Long userId, @RequestParam Long quizId) {
        int result = gradeService.calculateGrade(userId, quizId);
        return result == 1 ? ResponseEntity.ok("Grade calculated successfully") : ResponseEntity.status(500).body("Failed to calculate grade");
    }

    @GetMapping("/user/{userId}/quiz/{quizId}")
    public ResponseEntity<Grade> getGradeByUserIdAndQuizId(@PathVariable Long userId, @PathVariable Long quizId) {
        Grade grade = gradeService.getGradeByUserIdAndQuizId(userId, quizId);
        return grade != null ? ResponseEntity.ok(grade) : ResponseEntity.notFound().build();
    }
}

