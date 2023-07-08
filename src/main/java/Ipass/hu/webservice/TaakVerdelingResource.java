package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;
import Ipass.hu.huis.model.Taak;
import Ipass.hu.huis.model.TaakVerdeling;
import Ipass.hu.webservice.PersoonResource;
import Ipass.hu.webservice.TaakResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/taakverdeling")
public class TaakVerdelingResource {

    @Context
    private ServletContext servletContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaakVerdeling() {
        List<Taak> taken = (List<Taak>) servletContext.getAttribute("dummyTaken");
        List<Persoon> personen = (List<Persoon>) servletContext.getAttribute("dummyUsers");

        List<TaakVerdeling> taakVerdeling = new ArrayList<>();

        List<Taak> beschikbareTaken = new ArrayList<>(taken); // Maak een kopie van de takenlijst
// gaat door de personen en het aantal turven heen om deze aan iemand tpe te wijzig
        for (Persoon persoon : personen) {
            int aantalTurven = persoon.getAantal();

            for (int i = 0; i < aantalTurven; i++) {
                if (beschikbareTaken.isEmpty()) {
                    break; // Stop de lus als er geen taken meer beschikbaar zijn
                }

                int randomIndex = new Random().nextInt(beschikbareTaken.size()); // Kies een willekeurige index
                Taak taak = beschikbareTaken.get(randomIndex); // Krijg de taak op basis van de willekeurige index

                TaakVerdeling verdeling = new TaakVerdeling(persoon, taak);
                taakVerdeling.add(verdeling);
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(taakVerdeling);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
}}