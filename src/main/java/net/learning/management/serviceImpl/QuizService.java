package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Quiz;
import net.learning.management.repo.QuizDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {
    private final QuizDAO quizDAO;

    @Autowired
    public QuizService(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }

    public int addQuiz(Quiz quiz) {
        quiz.setCreatedAt(LocalDateTime.now());
        return quizDAO.save(quiz);
    }

    public Quiz getQuizById(Long id) {
        return quizDAO.findById(id);
    }

    public List<Quiz> getQuizzesByCourseId(Long courseId) {
        return quizDAO.findByCourseId(courseId);
    }
}

