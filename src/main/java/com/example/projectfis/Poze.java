package com.example.projectfis;

public class Poze {

    String nume, path;
    int contor, idpoza;

    public void setIdpoza(Integer idpoza) {
        this.idpoza = idpoza;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContor(Integer contor) {
        this.contor = contor;
    }



    public int getIdpoza() {
        return idpoza;
    }

    public String getNume() {
        return nume;
    }

    public String getPath() {
        return this.path;
    }

    public int getContor() {
        return this.contor;
    }


    public Poze(int idpoza, String nume, String path, int contor) {
        this.idpoza = idpoza;
        this.nume = nume;
        this.path=path;
        this.contor=contor;

    }

}