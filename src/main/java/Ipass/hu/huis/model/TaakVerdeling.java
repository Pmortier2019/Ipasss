package Ipass.hu.huis.model;


import java.util.ArrayList;
import java.util.List;

public class TaakVerdeling {
    private Persoon persoon;
    private Taak taak;

    public TaakVerdeling(Persoon persoon, Taak taak) {
        this.persoon = persoon;
        this.taak = taak;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Taak getTaak() {
        return taak;
    }

    public void setTaak(Taak taak) {
        this.taak = taak;
    }

    private List<TaakVerdeling> verdeelTaken(List<Taak> taken, List<Persoon> personen) {
        List<TaakVerdeling> taakVerdeling = new ArrayList<>();

        for (Persoon persoon : personen) {
            int aantalTurven = persoon.getAantal();

            for (int i = 0; i < aantalTurven; i++) {
                if (i >= taken.size()) {
                    // Als er meer turven zijn dan taken, herhaal de takenlijst
                    Taak taak = taken.get(i % taken.size());
                    taakVerdeling.add(new TaakVerdeling(persoon, taak));
                } else {
                    Taak taak = taken.get(i);
                    taakVerdeling.add(new TaakVerdeling(persoon, taak));
                }
            }
        }

        return taakVerdeling;
    }

}
