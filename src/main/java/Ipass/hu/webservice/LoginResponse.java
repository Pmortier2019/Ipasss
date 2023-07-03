package Ipass.hu.webservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(@JsonProperty("token") String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
