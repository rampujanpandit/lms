package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Answer;

public interface AnswerDAO {
    int save(Answer answer);
    List<Answer> findByUserIdAndQuizId(Long userId, Long quizId);
}

