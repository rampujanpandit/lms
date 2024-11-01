package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Notification;
import net.learning.management.serviceImpl.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam Long userId, @RequestParam String message) {
        int result = notificationService.sendNotification(userId, message);
        return result == 1 ? ResponseEntity.ok("Notification sent successfully") : ResponseEntity.status(500).body("Failed to send notification");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotificationsByUserId(userId));
    }

    @PutMapping("/{notificationId}/mark-seen")
    public ResponseEntity<String> markNotificationAsSeen(@PathVariable Long notificationId) {
        int result = notificationService.markNotificationAsSeen(notificationId);
        return result == 1 ? ResponseEntity.ok("Notification marked as seen") : ResponseEntity.status(500).body("Failed to mark notification as seen");
    }
}

