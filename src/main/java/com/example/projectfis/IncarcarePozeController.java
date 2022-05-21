package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class IncarcarePozeController {


    @FXML
    private TextField fotografie;

    @FXML
    private TextField nume;

    @FXML
    private Button incarcare;

    @FXML
    private Button back;

    @FXML
    private Label label;



    public void adaugarePoza(ActionEvent event) throws SQLException {
        if (fotografie.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();
            String addphoto = "INSERT INTO poze (nume, path) VALUES ('" + nume.getText() + "' ,'" + fotografie.getText() + "');";

            try {
                PreparedStatement preparedStmt = connectDB.prepareStatement(addphoto);
                preparedStmt.execute();
                label.setText("Incarcare reusita!");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }


    }

}