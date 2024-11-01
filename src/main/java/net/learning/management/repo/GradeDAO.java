package net.learning.management.repo;


import net.learning.management.entiry.Grade;

public interface GradeDAO {
    int save(Grade grade);
    Grade findByUserIdAndQuizId(Long userId, Long quizId);
}

