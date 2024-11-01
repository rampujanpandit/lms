package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Notification;

public interface NotificationDAO {
    int save(Notification notification);
    List<Notification> findByUserId(Long userId);
    int updateStatus(Long notificationId, String status);
}

