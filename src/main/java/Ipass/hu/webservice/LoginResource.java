package Ipass.hu.webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        if (username.equals("pieter") && password.equals("password")) {
            String token = generateToken(username);
            return Response.ok(new LoginResponse(token)).build();
        } else {
            // Inloggen is mislukt, stuur een foutmelding terug
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String generateToken(String username) {
        // Implementeer hier je logica om een JWT-token te genereren
        // Je kunt bibliotheken zoals jjwt gebruiken om dit te vereenvoudigen
        // Voorbeeld: return JWTUtils.generateToken(username);
        return "sample_token";
    }
}
