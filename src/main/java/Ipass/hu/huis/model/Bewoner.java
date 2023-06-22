package Ipass.hu.huis.model;

public abstract class Bewoner {
    private String naam;
    private int leeftijd;
    private boolean rol;


    public Bewoner(String nm, int lft, boolean rol){
        this.naam = nm;
        this.leeftijd = lft;
        this.rol = false;
    }
}
