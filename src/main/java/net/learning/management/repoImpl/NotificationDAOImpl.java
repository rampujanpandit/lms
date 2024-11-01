package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Notification;
import net.learning.management.repo.NotificationDAO;

import java.util.List;

@Repository
public class NotificationDAOImpl implements NotificationDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NotificationDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Notification notification) {
        String sql = "INSERT INTO notification (user_id, message, sent_at, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, notification.getUserId(), notification.getMessage(), notification.getSentAt(), notification.getStatus());
    }

    @Override
    public List<Notification> findByUserId(Long userId) {
        String sql = "SELECT * FROM notification WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Notification.class), userId);
    }

    @Override
    public int updateStatus(Long notificationId, String status) {
        String sql = "UPDATE notification SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, status, notificationId);
    }
}

