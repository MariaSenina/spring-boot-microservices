package org.ac.cst8277.senina.maria.usermanagementservice.dtos;

public class TokenResponseDto {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponseDto{" +
                "token='" + token + '\'' +
                '}';
    }
}
