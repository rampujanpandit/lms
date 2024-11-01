package net.learning.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Answer;
import net.learning.management.entiry.Grade;
import net.learning.management.repo.AnswerDAO;
import net.learning.management.repo.GradeDAO;
import net.learning.management.repo.QuestionDAO;

@Service
public class GradeService {
    private final GradeDAO gradeDAO;
    private final AnswerDAO answerDAO;
    private final QuestionDAO questionDAO;

    @Autowired
    public GradeService(GradeDAO gradeDAO, AnswerDAO answerDAO, QuestionDAO questionDAO) {
        this.gradeDAO = gradeDAO;
        this.answerDAO = answerDAO;
        this.questionDAO = questionDAO;
    }

    public int calculateGrade(Long userId, Long quizId) {
        List<Answer> answers = answerDAO.findByUserIdAndQuizId(userId, quizId);
        int totalMarks = 0;
        for (Answer answer : answers) {
            if (answer.isCorrect()) {
                totalMarks += 1; // Assume each correct answer is worth 1 mark
            }
        }
        Grade grade = new Grade();
        grade.setUserId(userId);
        grade.setQuizId(quizId);
        grade.setMarksObtained(totalMarks);
        return gradeDAO.save(grade);
    }

    public Grade getGradeByUserIdAndQuizId(Long userId, Long quizId) {
        return gradeDAO.findByUserIdAndQuizId(userId, quizId);
    }
}

