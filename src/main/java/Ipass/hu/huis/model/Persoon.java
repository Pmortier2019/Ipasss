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

    private String username;
    private String password;

    public Persoon() {
    }

    @JsonCreator
    public Persoon(@JsonProperty("naam") String naam, @JsonProperty("rol") String rol,
                   @JsonProperty("geslacht") String geslacht, @JsonProperty("aantal") int aantal,
                   @JsonProperty("id") String id, @JsonProperty("username") String username,
                   @JsonProperty("password") String password) {
        this.naam = naam;
        this.rol = rol;
        this.geslacht = geslacht;
        this.aantal = aantal;
        this.id = id;

        this.username = username;
        this.password = password;
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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
