package org.ac.cst8277.senina.maria.messageservice.dtos;

public class SubscriptionDto {
    private int id;
    private int subscriberId;
    private int producerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Override
    public String toString() {
        return "SubscriberDto{" +
                "id=" + id +
                ", subscriberId=" + subscriberId +
                ", producerId=" + producerId +
                '}';
    }
}
