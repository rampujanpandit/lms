package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Content;

public interface ContentDAO {
    int save(Content content);
    Content findById(Long id);
    List<Content> findByLessonId(Long lessonId);
}

