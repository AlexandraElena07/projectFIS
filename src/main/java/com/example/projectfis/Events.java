package com.example.projectfis;

public class Events {

    int id;

    String Titlu, Descriere;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitlu(String Titlu) {
        this.Titlu = Titlu;
    }

    public void setDescriere(String Descriere) {
        this.Descriere = Descriere;
    }

    public int getId() {
        return id;
    }

    public String getTitlu() {
        return Titlu;
    }

    public String getDescriere() {
        return Descriere;
    }

    public Events(int id, String Titlu, String Descriere) {
        this.id = id;
        this.Titlu = Titlu;
        this.Descriere = Descriere;
    }

}
