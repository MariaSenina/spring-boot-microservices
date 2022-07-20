package org.ac.cst8277.senina.maria.messageservice.services;

import org.ac.cst8277.senina.maria.messageservice.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    private final Integer USER_ID = 1;
    private final String TOKEN = "1dfef448-6e55-46b3-8582-3216b1d4004f";

    @Mock
    private UserRepository userRepository;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService(userRepository);
    }

    @Test
    void shouldCallAuthorizeWithSameParametersWhenParametersValid() {
        authService.authorizeUser(USER_ID, TOKEN);

        verify(userRepository).authorize(USER_ID, TOKEN);
    }

    @Test
    void shouldReturnBadRequestWhenAnyParameterNull() {
        HttpStatus result = authService.authorizeUser(null, TOKEN);

        assertEquals(HttpStatus.BAD_REQUEST, result);
    }

    @Test
    void shouldReturnBadRequestWhenTokenIsEmpty() {
        HttpStatus result = authService.authorizeUser(USER_ID, "");

        assertEquals(HttpStatus.BAD_REQUEST, result);
    }
}