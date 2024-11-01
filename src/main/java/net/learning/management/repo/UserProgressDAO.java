package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.UserProgress;

public interface UserProgressDAO {
    int save(UserProgress userProgress);
    UserProgress findByUserIdAndCourseId(Long userId, Long courseId);
    List<UserProgress> findByCourseId(Long courseId);
}

