package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Quiz;

public interface QuizDAO {
    int save(Quiz quiz);
    Quiz findById(Long id);
    List<Quiz> findByCourseId(Long courseId);
}

