package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/personen")
public class PersoonResource {


    @Context
    private ServletContext servletContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persoon> getPersonen() {
        List<Persoon> persons = (List<Persoon>) servletContext.getAttribute("dummyUsers");
        return persons;
    }


    @POST
    @Path("/update-person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Persoon updatedPerson) {
        List<Persoon> personen = (List<Persoon>) servletContext.getAttribute("dummyUsers");
        for (Persoon persoon : personen) {
            if (persoon.getId().equals(updatedPerson.getId())) {
                persoon.setAantal(updatedPerson.getAantal());
                break;
            }
        }

        servletContext.setAttribute("dummyUsers", personen);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(personen);
            return Response.ok().build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}