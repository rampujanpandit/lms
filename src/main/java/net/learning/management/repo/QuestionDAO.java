package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Question;

public interface QuestionDAO {
    int save(Question question);
    List<Question> findByQuizId(Long quizId);
}
