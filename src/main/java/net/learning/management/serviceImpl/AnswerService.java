package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Answer;
import net.learning.management.repo.AnswerDAO;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerService(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public int submitAnswer(Answer answer) {
        return answerDAO.save(answer);
    }

    public List<Answer> getAnswersByUserIdAndQuizId(Long userId, Long quizId) {
        return answerDAO.findByUserIdAndQuizId(userId, quizId);
    }
}

