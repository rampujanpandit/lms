package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Payment;

public interface PaymentDAO {
    int save(Payment payment);
    Payment findById(Long id);
    List<Payment> findByUserId(Long userId);
}
