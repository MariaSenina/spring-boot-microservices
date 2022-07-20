package org.ac.cst8277.senina.maria.messageservice.repositories;

import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionResponseDto;
import org.springframework.http.HttpStatus;

public interface UserRepository {
    SubscriptionResponseDto findSubscriptionsByUserId(int id);
    HttpStatus authorize(Integer id, String token);
}
