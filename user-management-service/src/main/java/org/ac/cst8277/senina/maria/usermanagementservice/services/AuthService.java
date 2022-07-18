package org.ac.cst8277.senina.maria.usermanagementservice.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private Map<Integer, String> userTokens;

    public AuthService() {
        userTokens = new HashMap();
    }

    public void setTokenForUser(Integer userId, String token) {
        userTokens.put(userId, token);
    }

    public boolean authorize(Integer userid, String token) {
        String validToken = userTokens.get(userid);
        return token.equals(validToken);
    }
}
