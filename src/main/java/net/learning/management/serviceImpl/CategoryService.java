package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Category;
import net.learning.management.repo.CategoryDAO;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public int addCategory(Category category) {
        return categoryDAO.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }
}

