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
        int huidigePersoonIndex = 0;
        for (Taak taak : taken) {
            Persoon persoon = personen.get(huidigePersoonIndex);
            int aantalTurven = persoon.getAantal();

            if (aantalTurven > 0) {
                TaakVerdeling verdeling = new TaakVerdeling(persoon, taak);
                taakVerdeling.add(verdeling);
                aantalTurven--;
                persoon.setAantal(aantalTurven - 1 );
            }

            huidigePersoonIndex++;
            if (huidigePersoonIndex >= personen.size()) {
                huidigePersoonIndex = 0;
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
    }
}