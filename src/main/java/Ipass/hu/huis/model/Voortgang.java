package Ipass.hu.huis.model;

import Ipass.hu.huis.model.Taak;

import java.util.ArrayList;

public class Voortgang {
    private int turven;
    private ArrayList<Taak> alleTaken = new ArrayList<>();


    public Voortgang(int turven){
        this.turven = 0;
    }

}
