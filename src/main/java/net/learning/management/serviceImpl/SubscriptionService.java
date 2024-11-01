package net.learning.management.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learning.management.entiry.Subscription;
import net.learning.management.repo.SubscriptionDAO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionDAO subscriptionDAO;

    @Autowired
    public SubscriptionService(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    public int startSubscription(Long userId, String plan) {
        Subscription subscription = new Subscription();
        subscription.setUserId(userId);
        subscription.setPlan(plan);
        subscription.setStartDate(LocalDateTime.now());
        subscription.setEndDate(plan.equals("monthly") ? LocalDateTime.now().plusMonths(1) : LocalDateTime.now().plusYears(1));
        subscription.setStatus("active");
        return subscriptionDAO.save(subscription);
    }

    public Subscription getSubscriptionByUserId(Long userId) {
        return subscriptionDAO.findByUserId(userId);
    }

    public List<Subscription> getActiveSubscriptions() {
        return subscriptionDAO.findActiveSubscriptions();
    }
}
