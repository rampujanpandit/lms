package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Media;

public interface MediaDAO {
    int save(Media media);
    List<Media> findAll();
}

