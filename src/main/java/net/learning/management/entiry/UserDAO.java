package net.learning.management.entiry;

public interface UserDAO {
    int save(User user);
    User findById(Long id);
}

