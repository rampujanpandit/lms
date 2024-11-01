package net.learning.management.repoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.learning.management.entiry.Payment;
import net.learning.management.repo.PaymentDAO;

import java.util.List;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Payment payment) {
        String sql = "INSERT INTO payment (user_id, course_id, amount, payment_date, payment_status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, payment.getUserId(), payment.getCourseId(), payment.getAmount(), payment.getPaymentDate(), payment.getPaymentStatus());
    }

    @Override
    public Payment findById(Long id) {
        String sql = "SELECT * FROM payment WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Payment.class), id);
    }

    @Override
    public List<Payment> findByUserId(Long userId) {
        String sql = "SELECT * FROM payment WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Payment.class), userId);
    }
}

