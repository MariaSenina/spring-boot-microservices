package org.ac.cst8277.senina.maria.messageservice.repositories;

import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionResponseDto;

public interface UserRepository {
    SubscriptionResponseDto findSubscriptionsByUserId(int id);
}
