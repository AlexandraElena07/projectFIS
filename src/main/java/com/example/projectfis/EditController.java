package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditController {

    @FXML
    private TextField conservare;

    @FXML
    private TextField descriere;

    @FXML
    private TextField habitat;

    @FXML
    private TextField id;

    @FXML
    private Button inchidere;

    @FXML
    private TextField nume;

    @FXML
    private TextField regiune;

    @FXML
    private Button salvare;

    @FXML
    private TextField tip;

    @FXML
    private Label editLabel;

    @FXML
    public void save(ActionEvent event) {

        if (id.getText().isBlank() == false || descriere.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();


            String animale = "UPDATE animale set descriere = '" + descriere.getText() + "'WHERE id = '" + id.getText() + "'";
            String searchID = "SELECT * FROM animale WHERE id = '" + id.getText() + "'";


            try {Statement st1 = connectDB.createStatement();
                Statement st2 = connectDB.createStatement();

                ResultSet queryResult = st1.executeQuery(searchID);
                int ok = 0;

                while (queryResult.next()) {

                    if (queryResult.getInt(1) != 1) {
                        editLabel.setText("Informațiile au fost editate!");
                        st2.executeUpdate(animale);
                        ok = 1;

                    }

                }

                if (ok == 0) editLabel.setText("ID-ul introdus nu există!");



            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) inchidere.getScene().getWindow();
        stage.close();
    }

}