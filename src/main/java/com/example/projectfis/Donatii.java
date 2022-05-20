package com.example.projectfis;

public class Donatii {

    String nume;
    int sumadonata, id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setSumadonata(Integer sumadonata) {
        this.sumadonata = sumadonata;
    }



    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getSumadonata() {
        return this.sumadonata;
    }


    public Donatii(int id, String nume, int sumadonata) {
        this.id = id;
        this.nume = nume;
        this.sumadonata = sumadonata;

    }

}