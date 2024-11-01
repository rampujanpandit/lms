package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.CourseStats;
import net.learning.management.repo.CourseStatsDAO;

@Service
public class CourseStatsService {
    private final CourseStatsDAO courseStatsDAO;

    @Autowired
    public CourseStatsService(CourseStatsDAO courseStatsDAO) {
        this.courseStatsDAO = courseStatsDAO;
    }

    public CourseStats getCourseStats(Long courseId) {
        return courseStatsDAO.findByCourseId(courseId);
    }

    public int updateEnrollmentCount(Long courseId, int enrollmentCount) {
        return courseStatsDAO.updateEnrollmentCount(courseId, enrollmentCount);
    }

    public int updateCompletionCount(Long courseId, int completionCount) {
        return courseStatsDAO.updateCompletionCount(courseId, completionCount);
    }

    public int updateAverageRating(Long courseId, double averageRating) {
        return courseStatsDAO.updateAverageRating(courseId, averageRating);
    }
}

