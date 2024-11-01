package net.learning.management.repo;


import net.learning.management.entiry.CourseStats;

public interface CourseStatsDAO {
    CourseStats findByCourseId(Long courseId);
    int updateEnrollmentCount(Long courseId, int enrollmentCount);
    int updateCompletionCount(Long courseId, int completionCount);
    int updateAverageRating(Long courseId, double averageRating);
}
