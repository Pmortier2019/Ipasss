package Ipass.resource;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Ipass.hu.huis.model.Taak;

public class TaakResource extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        ObjectNode jsonResponse = mapper.createObjectNode();
        
        try {
            Taak data = mapper.readValue(requestBody, Taak.class);
            String taak = data.getTaak();
            
            jsonResponse.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse.put("success", false);
        }
        
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
    }
}
