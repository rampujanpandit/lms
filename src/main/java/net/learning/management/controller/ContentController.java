package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Content;
import net.learning.management.serviceImpl.ContentService;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {
    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContent(@RequestBody Content content) {
        int result = contentService.addContent(content);
        return result == 1 ? ResponseEntity.ok("Content added successfully") : ResponseEntity.status(500).body("Failed to add content");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        Content content = contentService.getContentById(id);
        return content != null ? ResponseEntity.ok(content) : ResponseEntity.notFound().build();
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<Content>> getContentsByLessonId(@PathVariable Long lessonId) {
        return ResponseEntity.ok(contentService.getContentsByLessonId(lessonId));
    }
}
