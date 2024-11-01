package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Message;
import net.learning.management.repo.MessageDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    private final MessageDAO messageDAO;

    @Autowired
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public int sendMessage(Long senderId, Long receiverId, String messageText) {
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setMessageText(messageText);
        message.setSentAt(LocalDateTime.now());
        return messageDAO.save(message);
    }

    public List<Message> getMessagesByReceiverId(Long receiverId) {
        return messageDAO.findByReceiverId(receiverId);
    }
}

