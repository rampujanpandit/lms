package net.learning.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.learning.management.entiry.Subscription;
import net.learning.management.serviceImpl.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/start")
    public ResponseEntity<String> startSubscription(@RequestParam Long userId, @RequestParam String plan) {
        int result = subscriptionService.startSubscription(userId, plan);
        return result == 1 ? ResponseEntity.ok("Subscription started successfully") : ResponseEntity.status(500).body("Failed to start subscription");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionByUserId(userId));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Subscription>> getActiveSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getActiveSubscriptions());
    }
}

