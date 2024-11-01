package net.learning.management.repo;
import java.util.List;

import net.learning.management.entiry.Role;

public interface RoleDAO {
    int save(Role role);
    Role findByName(String name);
    List<Role> findAll();
}
