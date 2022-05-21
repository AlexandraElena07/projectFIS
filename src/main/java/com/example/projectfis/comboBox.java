package com.example.projectfis;

public class comboBox {

    int lionID, count;
    String lionName;

    public comboBox(int lionID, String lionName, int count) {
        this.lionID = lionID;
        this.lionName = lionName;
        this.count = count;
    }

    public int getLionID() {
        return  lionID;
    }

    public void setLionID(int lionID) {
        this.lionID = lionID;
    }

    public String getLionName() {
        return lionName;
    }

    public void setLionName(String lionName) {
        this.lionName = lionName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
