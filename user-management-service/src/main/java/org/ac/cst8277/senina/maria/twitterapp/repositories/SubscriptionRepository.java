package org.ac.cst8277.senina.maria.twitterapp.repositories;

import org.ac.cst8277.senina.maria.twitterapp.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    List<Subscription> findBySubscriberId(int id);
}
