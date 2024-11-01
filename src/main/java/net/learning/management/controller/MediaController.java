package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Media;
import net.learning.management.serviceImpl.MediaService;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMedia(@RequestBody Media media) {
        int result = mediaService.addMedia(media);
        return result == 1 ? ResponseEntity.ok("Media added successfully") : ResponseEntity.status(500).body("Failed to add media");
    }

    @GetMapping
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }
}

