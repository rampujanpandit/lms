package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Question;
import net.learning.management.repo.QuestionDAO;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionService(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public int addQuestion(Question question) {
        return questionDAO.save(question);
    }

    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionDAO.findByQuizId(quizId);
    }
}

