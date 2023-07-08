package Ipass.hu.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

//@Path("/login")
public class AuthenticationResource {
    public static Key key = MacProvider.generateKey();
    public static Date fiveMinuesFromNow = Date.from(Instant.now().plusSeconds(150 * 60));


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response Login(LoginRequest loginRequest) {
        if (loginRequest.username.equals("pieter") && loginRequest.password.equals("test")) {
            String token = Jwts.builder()
                    .setSubject("pieter")
                    .setIssuer("finalassignment")
                    .setExpiration(fiveMinuesFromNow)
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
            return Response.ok(TokenResponse.fromString(token)).build();
        } else {
            return Response.status(401).entity("doet niet").build();
        }
    }


    @GET
    @Path("/token")
    @Produces("application/json")
    public Boolean validatieToken() {
        return !fiveMinuesFromNow.before(Date.from(Instant.now()));

    }

}
