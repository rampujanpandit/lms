package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Payment;
import net.learning.management.repo.PaymentDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentDAO paymentDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public int makePayment(Long userId, Long courseId, double amount) {
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setCourseId(courseId);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentStatus("completed"); // Assume successful payment for now
        return paymentDAO.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDAO.findById(id);
    }

    public List<Payment> getPaymentsByUserId(Long userId) {
        return paymentDAO.findByUserId(userId);
    }
}
