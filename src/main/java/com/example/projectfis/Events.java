package com.example.projectfis;

public class Events {

    String id;

    String Titlu, Descriere;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitlu(String Titlu) {
        this.Titlu = Titlu;
    }

    public void setDescriere(String Descriere) {
        this.Descriere = Descriere;
    }

    public String getId() {
        return id;
    }

    public String getTitlu() {
        return Titlu;
    }

    public String getDescriere() {
        return Descriere;
    }

    public Events(String id, String Titlu, String Descriere) {
        this.id = id;
        this.Titlu = Titlu;
        this.Descriere = Descriere;
    }

}
