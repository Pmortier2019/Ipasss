package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;
import Ipass.hu.huis.model.Taak;
import Ipass.hu.huis.model.TaakVerdeling;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/taken")
public class TaakResource {


    @Context
    private ServletContext servletContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Taak> getTaken() {
        List<Taak> dummyTaken = (List<Taak>) servletContext.getAttribute("dummyTaken");

        return dummyTaken;
    }

    @POST
    @Path("/update-taken")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTaak(Taak newTaak) {
        List<Taak> dummyTaken = (List<Taak>) servletContext.getAttribute("dummyTaken");

        int newId = dummyTaken.size() + 1;
        newTaak.setId(newId);

        dummyTaken.add(newTaak);

        servletContext.setAttribute("dummyTaken", dummyTaken);

        return Response.ok().entity("{\"success\": true}").build();
    }


}



