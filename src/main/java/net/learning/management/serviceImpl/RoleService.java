package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Role;
import net.learning.management.repo.RoleDAO;

import java.util.List;

@Service
public class RoleService {
    private final RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public int addRole(Role role) {
        return roleDAO.save(role);
    }

    public List<Role> getAllRoles() {
        return roleDAO.findAll();
    }
}

