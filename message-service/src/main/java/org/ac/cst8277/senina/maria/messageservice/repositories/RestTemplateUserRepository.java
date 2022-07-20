package org.ac.cst8277.senina.maria.messageservice.repositories;

import org.ac.cst8277.senina.maria.messageservice.dtos.SubscriptionResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
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

    @Override
    public HttpStatus authorize(Integer id, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<Object> request = new HttpEntity<>(headers);
        HttpStatus responseHttpStatus;

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(BASE_URI + "/auth?id=" + id, request, String.class);
            responseHttpStatus = response.getStatusCode();
        } catch (HttpClientErrorException e) {
            responseHttpStatus = e.getStatusCode();
        }

        return responseHttpStatus;
    }
}
