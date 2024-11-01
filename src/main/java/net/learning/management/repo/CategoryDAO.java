package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Category;

public interface CategoryDAO {
    int save(Category category);
    List<Category> findAll();
}
