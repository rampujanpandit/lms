package net.learning.management.repo;

import net.learning.management.entiry.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    int save(User user);
    Optional<User> findByUsername(String username);
    User findById(Long id);
    List<User> findAll();
}


