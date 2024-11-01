package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Course;

public interface CourseDAO {
    int save(Course course);
    Course findById(Long id);
    List<Course> findAll();
}

