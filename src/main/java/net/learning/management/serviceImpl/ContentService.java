package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Content;
import net.learning.management.repo.ContentDAO;

import java.util.List;

@Service
public class ContentService {
    private final ContentDAO contentDAO;

    @Autowired
    public ContentService(ContentDAO contentDAO) {
        this.contentDAO = contentDAO;
    }

    public int addContent(Content content) {
        return contentDAO.save(content);
    }

    public Content getContentById(Long id) {
        return contentDAO.findById(id);
    }

    public List<Content> getContentsByLessonId(Long lessonId) {
        return contentDAO.findByLessonId(lessonId);
    }
}

