package org.ac.cst8277.senina.maria.messageservice.repositories;

import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RestTemplateUserRepository implements UserRepository {
    private static final String BASE_URI = "http://localhost:8080";

    @Override
    public SubscriptionResponseDto findSubscriptionsByUserId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SubscriptionResponseDto> response
                = restTemplate.getForEntity(BASE_URI + "/users/"+ id + "/subscriptions", SubscriptionResponseDto.class);

        return response.getBody();
    }
}
