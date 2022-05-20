package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddEventsController {

    @FXML
    private TextField descriere;

    @FXML
    private TextField id;

    @FXML
    private Button inchidere;

    @FXML
    private TextField titlu;

    @FXML
    private Button save;

    @FXML
    private Label saveLabel;

    @FXML
    void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) inchidere.getScene().getWindow();
        stage.close();
    }

    @FXML
    void save(ActionEvent event) throws Exception {
        if (titlu.getText().isBlank() == false || descriere.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            String evenimente = "INSERT INTO events (Titlu, Descriere) VALUES ('" + titlu.getText() + "', '" + descriere.getText() + "')";


            try {
                PreparedStatement preparedStmt = connectDB.prepareStatement(evenimente);
                preparedStmt.execute();
                saveLabel.setText("Detaliile au fost adaugate cu succes!");


            } catch (Exception e) {
                saveLabel.setText("Titlul evenimentului exista deja!");
            }

        }
    }
}


