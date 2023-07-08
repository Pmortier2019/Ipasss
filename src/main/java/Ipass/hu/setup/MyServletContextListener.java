package Ipass.hu.setup;

import Ipass.hu.huis.model.Persoon;
import Ipass.hu.huis.model.Taak;
import Ipass.hu.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;


@WebListener
public class MyServletContextListener implements ServletContextListener {


    private List<Persoon> dummyUsers;



    public void contextInitialized(ServletContextEvent sce) {
        try {
            List<Taak> dummyTaken = new ArrayList<>();

            List<Persoon> dummyUsers = new ArrayList<>();

            dummyTaken.add(new Taak("Afwassen", "30 minuten", "Het afwassen van de vuile vaat in de keuken.", 1));
            dummyTaken.add(new Taak("Stofzuigen", "45 minuten", "Het stofzuigen van alle kamers en tapijten in het huis.", 2));
            dummyTaken.add(new Taak("Dweilen", "30 minuten", "Het dweilen van de vloeren om ze schoon en glanzend te maken.", 3));
            dummyTaken.add(new Taak("Ramen lappen", "60 minuten", "Het reinigen van de ramen zowel van binnen als van buiten.", 4));
            dummyTaken.add(new Taak("Boodschappen doen", "60 minuten", "Het doen van de wekelijkse boodschappen bij de supermarkt.", 5));
            dummyTaken.add(new Taak("Koken", "45 minuten", "Het bereiden van een heerlijke maaltijd voor het hele gezin.", 6));
            dummyTaken.add(new Taak("Bed opmaken", "10 minuten", "Het netjes opmaken van het bed en het vervangen van het beddengoed.", 7));
            dummyTaken.add(new Taak("Badkamer schoonmaken", "30 minuten", "Het grondig schoonmaken van de wastafel, douche en toilet.", 8));
            dummyTaken.add(new Taak("Wasgoed wassen", "60 minuten", "Het sorteren, wassen en drogen van de vuile was.", 9));
            dummyTaken.add(new Taak("Strijken", "30 minuten", "Het strijken van de gewassen kleding om ze kreukvrij te maken.", 10));
            dummyTaken.add(new Taak("Planten water geven", "15 minuten", "Het geven van water aan de kamerplanten in huis.", 11));
            dummyTaken.add(new Taak("Tuin onderhouden", "60 minuten", "Het maaien van het gras, snoeien van struiken en verwijderen van onkruid in de tuin.", 12));
            dummyTaken.add(new Taak("Afval scheiden", "10 minuten", "Het sorteren van het afval in verschillende containers.", 13));
            dummyTaken.add(new Taak("Keuken schoonmaken", "30 minuten", "Het schoonmaken van het aanrecht, fornuis en de keukenapparatuur.", 14));
            dummyTaken.add(new Taak("Stoffen", "20 minuten", "Het afstoffen van meubels, planken en andere oppervlakken.", 15));
            dummyTaken.add(new Taak("Koelkast schoonmaken", "30 minuten", "Het schoonmaken en opruimen van de koelkast.", 16));
            dummyTaken.add(new Taak("Vuilnisbak legen", "5 minuten", "Het legen van de vuilnisbakken in huis.", 17));
            dummyTaken.add(new Taak("Vaatwasser uitruimen", "10 minuten", "Het uitruimen van de schone vaatwasser en het opruimen van de serviesgoed.", 18));
            dummyTaken.add(new Taak("Buiten vegen", "15 minuten", "Het vegen van de stoep en de buitenruimte rondom het huis.", 19));
            dummyTaken.add(new Taak("Opruimen", "20 minuten", "Het opruimen van speelgoed, boeken en andere spullen in huis.", 20));




            dummyUsers.add(new Persoon("Pieter", "Bewoner", "Man", 3, "1", "pieter", "password"));
            dummyUsers.add(new Persoon("Reinder", "Bewoner", "Vrouw", 7, "2", "reinder456", "password2"));
            dummyUsers.add(new Persoon("Cristiano Ronaldo", "Bewoner", "Man", 2, "3", "cristiano789", "password3"));
            dummyUsers.add(new Persoon("Beatrix", "Bewoner", "Vrouw", 1, "4", "beatrix101", "password4"));




            sce.getServletContext().setAttribute("dummyTaken", dummyTaken);
            sce.getServletContext().setAttribute("dummyUsers", dummyUsers);

            PersistenceManager.loadFromAzure();
        } catch (Exception e) {
            System.out.println("Error laden van de data!");
            e.printStackTrace();
        }


        System.out.println("ContextListener - Initialized");

    }
    public List<Persoon> getDummyUsers() {
        return dummyUsers;
    }
    public void setDummyUsers(List<Persoon> dummyUsers) {
        this.dummyUsers = dummyUsers;
    }
}
