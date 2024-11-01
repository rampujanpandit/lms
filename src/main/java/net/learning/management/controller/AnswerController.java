package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Answer;
import net.learning.management.serviceImpl.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestBody Answer answer) {
        int result = answerService.submitAnswer(answer);
        return result == 1 ? ResponseEntity.ok("Answer submitted successfully") : ResponseEntity.status(500).body("Failed to submit answer");
    }

    @GetMapping("/user/{userId}/quiz/{quizId}")
    public ResponseEntity<List<Answer>> getAnswersByUserIdAndQuizId(@PathVariable Long userId, @PathVariable Long quizId) {
        return ResponseEntity.ok(answerService.getAnswersByUserIdAndQuizId(userId, quizId));
    }
}

