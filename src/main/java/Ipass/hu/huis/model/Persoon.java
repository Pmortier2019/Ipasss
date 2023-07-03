package Ipass.hu.huis.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Persoon {
    private String naam;
    private String rol;
    private String geslacht;
    private int aantal;
    private String id;

    // Standaardconstructor (vereist voor JSON-mapping)
    public Persoon() {
    }

    @JsonCreator
    public Persoon(@JsonProperty("naam") String naam, @JsonProperty("rol") String rol,
                   @JsonProperty("geslacht") String geslacht, @JsonProperty("aantal") int aantal,
                   @JsonProperty("id") String id) {
        this.naam = naam;
        this.rol = rol;
        this.geslacht = geslacht;
        this.aantal = aantal;
        this.id = id;
    }

    // Getters en setters

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Dummy data
    public static List<Persoon> createSampleUsers() {
        List<Persoon> users = new ArrayList<>();

        users.add(new Persoon("Pieter", "Bewoner", "Man", 3, "1"));
        users.add(new Persoon("Reinder", "Bewoner", "Vrouw", 0, "2"));
        users.add(new Persoon("Cristiano ronaldo", "Bewoner", "Man", 4, "3"));
        users.add(new Persoon("Beatrix", "Bewoner", "Vrouw", 14, "4"));

        return users;
    }
}
