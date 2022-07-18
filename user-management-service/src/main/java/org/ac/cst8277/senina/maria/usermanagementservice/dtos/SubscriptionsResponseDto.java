package org.ac.cst8277.senina.maria.usermanagementservice.dtos;

import org.ac.cst8277.senina.maria.usermanagementservice.entities.Subscription;

import java.util.List;

public class SubscriptionsResponseDto {
    private List<Subscription> subscriptions;

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "SubscriptionsResponseDto{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
