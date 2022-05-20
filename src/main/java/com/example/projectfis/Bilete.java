package com.example.projectfis;

public class Bilete {

    String nume, tip;
    int id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }



    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getTip() {
        return this.tip;
    }


    public Bilete(int id, String nume, String tip) {
        this.id = id;
        this.nume = nume;
        this.tip = tip;

    }

}