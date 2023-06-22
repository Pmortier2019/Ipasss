package Ipass.hu.huis.model;

import java.util.Date;

public class Taak {
    private int id;
    private String omschrijving;
    private Date deadline;
    private boolean voltooid;


    public Taak(int id, String omschrijving, Date deadline, boolean voltooid) {
        this.id = id;
        this.omschrijving = omschrijving;
        this.deadline = deadline;
        this.voltooid = voltooid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public void setVoltooid(boolean voltooid) {
        this.voltooid = voltooid;
    }


    public String getTaak() {
        return null;
    }
}
