package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Message;

public interface MessageDAO {
    int save(Message message);
    List<Message> findByReceiverId(Long receiverId);
}

