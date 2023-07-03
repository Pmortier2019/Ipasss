package Ipass.hu.huis.model;

import java.util.ArrayList;
import java.util.List;

public class Taak {
    private String naam;
    private String duur;
    private String omschrijving;
    private int id;
    private static List<Taak> taken = new ArrayList<>();

    public Taak() {
    }

    public Taak(String naam, String duur, String omschrijving, int id) {
        this.naam = naam;
        this.duur = duur;
        this.omschrijving = omschrijving;
        this.id = id;
    }

    public static List<Taak> getTaken() {
        return taken;
    }

    public static void addTaak(Taak taak) {
        taken.add(taak);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDuur() {
        return duur;
    }

    public void setDuur(String duur) {
        this.duur = duur;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
