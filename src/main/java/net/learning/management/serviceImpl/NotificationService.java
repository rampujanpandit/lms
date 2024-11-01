package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Notification;
import net.learning.management.repo.NotificationDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationDAO notificationDAO;

    @Autowired
    public NotificationService(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    public int sendNotification(Long userId, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());
        notification.setStatus("unseen");
        return notificationDAO.save(notification);
    }

    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationDAO.findByUserId(userId);
    }

    public int markNotificationAsSeen(Long notificationId) {
        return notificationDAO.updateStatus(notificationId, "seen");
    }
}

