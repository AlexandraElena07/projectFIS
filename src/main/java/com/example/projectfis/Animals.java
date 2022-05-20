package com.example.projectfis;

public class Animals {

    String  Nume, Descriere, Regiune, Habitat, Tip, Conservare;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public void setDescriere(String Descriere) {
        this.Descriere = Descriere;
    }

    public void setRegiune(String Regiune) {
        this.Regiune = Regiune;
    }

    public void setHabitat(String Habitat) {
        this.Habitat = Habitat;
    }

    public void setTip(String Tip) {
        this.Tip = Tip;
    }

    public void setConservare(String Conservare) {
        this.Conservare = Conservare;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return Nume;
    }

    public String getDescriere() {
        return Descriere;
    }

    public String getRegiune() {
        return Regiune;
    }

    public String getHabitat() {
        return Habitat;
    }

    public String getTip() {
        return Tip;
    }

    public String getConservare() {
        return Conservare;
    }

    public Animals(int id, String Nume, String Descriere, String Regiune, String Habitat, String Tip, String Conservare) {
        this.id = id;
        this.Nume = Nume;
        this.Descriere = Descriere;
        this.Regiune = Regiune;
        this.Habitat = Habitat;
        this.Tip = Tip;
        this.Conservare = Conservare;
    }

}


