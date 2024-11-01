package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Media;
import net.learning.management.repo.MediaDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MediaService {
    private final MediaDAO mediaDAO;

    @Autowired
    public MediaService(MediaDAO mediaDAO) {
        this.mediaDAO = mediaDAO;
    }

    public int addMedia(Media media) {
        media.setUploadDate(LocalDateTime.now());
        return mediaDAO.save(media);
    }

    public List<Media> getAllMedia() {
        return mediaDAO.findAll();
    }
}

