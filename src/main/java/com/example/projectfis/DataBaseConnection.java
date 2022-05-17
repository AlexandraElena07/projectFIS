package com.example.projectfis;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        ///String databaseName = "conturi_de_utilizator";
        String databaseUser= "root";
        String databasePassword= "root!";
        String url= "jdbc:mysql://localhost:3306/demo_db";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
