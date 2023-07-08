package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/login")
public class LoginResource {

    @Context
    private ServletContext servletContext;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Persoon request) {
        String username = request.getUsername();
        String password = request.getPassword();
        List<Persoon> dummyUsers = (List<Persoon>) servletContext.getAttribute("dummyUsers");
// controleeer ww en pw
        for (Persoon user : dummyUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                String token = generateToken(username);
                return Response.ok(new LoginResponse(token)).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    private String generateToken(String username) {
        return "sample_token";
    }
}
