package Ipass.hu.setup;

import Ipass.hu.huis.model.Persoon;
import Ipass.hu.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;


@WebListener
public class MyServletContextListener implements ServletContextListener {



    public static ArrayList<Persoon> personen= new ArrayList<Persoon>();


    public void contextInitialized(ServletContextEvent sce) {
        try {
            PersistenceManager.loadFromAzure();
        } catch (Exception e) {
            System.out.println("Error laden van de data!");
            e.printStackTrace();
        }


        System.out.println("ContextListener - Initialized");

    }}
