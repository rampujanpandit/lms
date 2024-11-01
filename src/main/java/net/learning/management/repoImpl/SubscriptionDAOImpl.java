package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Subscription;
import net.learning.management.repo.SubscriptionDAO;

import java.util.List;

@Repository
public class SubscriptionDAOImpl implements SubscriptionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubscriptionDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Subscription subscription) {
        String sql = "INSERT INTO subscription (user_id, plan, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, subscription.getUserId(), subscription.getPlan(), subscription.getStartDate(), subscription.getEndDate(), subscription.getStatus());
    }

    @Override
    public Subscription findByUserId(Long userId) {
        String sql = "SELECT * FROM subscription WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Subscription.class), userId);
    }

    @Override
    public List<Subscription> findActiveSubscriptions() {
        String sql = "SELECT * FROM subscription WHERE status = 'active'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscription.class));
    }
}

