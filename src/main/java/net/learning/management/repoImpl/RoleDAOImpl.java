package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Role;
import net.learning.management.repo.RoleDAO;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Role role) {
        String sql = "INSERT INTO role (name) VALUES (?)";
        return jdbcTemplate.update(sql, role.getName());
    }

    @Override
    public Role findByName(String name) {
        String sql = "SELECT * FROM role WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Role.class), name);
    }

    @Override
    public List<Role> findAll() {
        String sql = "SELECT * FROM role";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
    }
}

