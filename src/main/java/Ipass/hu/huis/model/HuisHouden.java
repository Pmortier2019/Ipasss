package Ipass.hu.huis.model;

import Ipass.hu.huis.model.Bewoner;

import java.util.ArrayList;

public class HuisHouden {

    private String huisNaam;
    private ArrayList<Bewoner> bewoners = new ArrayList<>();

    public HuisHouden(String hnm){
        this.huisNaam = hnm;
    }
}
