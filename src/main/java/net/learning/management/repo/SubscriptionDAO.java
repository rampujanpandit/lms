
package net.learning.management.repo;

import java.util.List;

import net.learning.management.entiry.Subscription;

public interface SubscriptionDAO {
    int save(Subscription subscription);
    Subscription findByUserId(Long userId);
    List<Subscription> findActiveSubscriptions();
}
