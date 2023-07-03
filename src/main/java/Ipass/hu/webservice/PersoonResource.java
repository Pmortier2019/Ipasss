package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.ws.rs.*;
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



        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getPersonen() {
            List<Persoon> personen = Persoon.createSampleUsers();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(personen);
                return Response.ok(json).build();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }



    @POST
    @Path("/update-person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Persoon updatedPerson) {
        List<Persoon> personen = Persoon.createSampleUsers();

        // Zoek de juiste persoon in de lijst en werk het aantal bij
        for (Persoon persoon : personen) {
            if (persoon.getId().equals(updatedPerson.getId())) {
                persoon.setAantal(updatedPerson.getAantal());
                break;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(personen);
            // Schrijf de bijgewerkte gegevens naar een JSON-bestand of een database
            // Implementeer hier de code om de gegevens op te slaan

            return Response.ok().build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }}