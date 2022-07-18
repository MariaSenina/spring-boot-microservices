package org.ac.cst8277.senina.maria.messageservice.dtos;

import java.util.List;

public class SubscriptionResponseDto {
    private List<SubscriptionDto> subscriptions;

    public List<SubscriptionDto> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionDto> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "SubscriptionResponseDto{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
