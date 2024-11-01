package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.UserProgress;
import net.learning.management.repo.UserProgressDAO;

import java.util.List;

@Service
public class UserProgressService {
    private final UserProgressDAO userProgressDAO;

    @Autowired
    public UserProgressService(UserProgressDAO userProgressDAO) {
        this.userProgressDAO = userProgressDAO;
    }

    public int updateProgress(Long userId, Long courseId, double progressPercentage, String lastAccessed) {
        UserProgress progress = userProgressDAO.findByUserIdAndCourseId(userId, courseId);
        if (progress != null) {
            progress.setProgressPercentage(progressPercentage);
            progress.setLastAccessed(lastAccessed);
            return userProgressDAO.save(progress);
        } else {
            return -1; // Progress record not found
        }
    }

    public List<UserProgress> getProgressByCourseId(Long courseId) {
        return userProgressDAO.findByCourseId(courseId);
    }
}

