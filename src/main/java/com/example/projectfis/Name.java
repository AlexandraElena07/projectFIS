package com.example.projectfis;

public class Name {

    String name;
    int count, id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count=count;

    }

}