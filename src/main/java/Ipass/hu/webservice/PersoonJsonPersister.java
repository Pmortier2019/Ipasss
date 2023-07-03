package Ipass.hu.webservice;

import Ipass.hu.huis.model.Persoon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersoonJsonPersister {
    private static final String JSON_FILE_PATH = "personen.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Persoon> loadPersonen() {
        try {
            return objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<Persoon>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // Of gooi een specifieke uitzondering om het probleem aan te geven
            return null;
        }
    }

    public static void savePersonen(List<Persoon> personen) {
        try {
            objectMapper.writeValue(new File(JSON_FILE_PATH), personen);
        } catch (IOException e) {
            e.printStackTrace();
            // Of gooi een specifieke uitzondering om het probleem aan te geven
        }
    }
}
