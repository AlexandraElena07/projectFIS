package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddController {

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
    private Label saveLabel;

    @FXML
    public void save(ActionEvent event) throws  Exception {
        if (nume.getText().isBlank() == false || descriere.getText().isBlank() == false || regiune.getText().isBlank() == false || habitat.getText().isBlank() == false || tip.getText().isBlank() == false || conservare.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();



            String animale = "INSERT INTO animale (Nume, Descriere, Regiune, Habitat, Tip, Conservare) VALUES ('" +  nume.getText() + "', '" + descriere.getText() + "', '" + regiune.getText() + "', '" + habitat.getText() + "', '" + tip.getText() + "', '" + conservare.getText() + "')";


            try {

                PreparedStatement preparedStmt = connectDB.prepareStatement(animale);
                preparedStmt.execute();
                saveLabel.setText("Informațiile au fost adăugate cu succes!");



            } catch (Exception e) {
                saveLabel.setText("Numele introdus există deja!");
            }

        }
    }


    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) inchidere.getScene().getWindow();
        stage.close();
    }

}
