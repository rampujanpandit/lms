package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Message;
import net.learning.management.repo.MessageDAO;

import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Message message) {
        String sql = "INSERT INTO message (sender_id, receiver_id, message_text, sent_at) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, message.getSenderId(), message.getReceiverId(), message.getMessageText(), message.getSentAt());
    }

    @Override
    public List<Message> findByReceiverId(Long receiverId) {
        String sql = "SELECT * FROM message WHERE receiver_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class), receiverId);
    }
}
