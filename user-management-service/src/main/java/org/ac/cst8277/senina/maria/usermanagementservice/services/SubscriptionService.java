package org.ac.cst8277.senina.maria.usermanagementservice.services;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.Subscription;
import org.ac.cst8277.senina.maria.usermanagementservice.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> findSubscriptionsByUserId(int id) {
        return subscriptionRepository.findBySubscriberId(id);
    }
}
