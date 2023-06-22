package Ipass.hu.security;

public class TokenResponse {
    public String token;

    public static TokenResponse fromString(String token){
        TokenResponse resp = new TokenResponse();
        resp.token = token;
        return resp;
    }
}
