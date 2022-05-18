package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.File;

public class DonatiiController implements  Initializable{
    @FXML
    private ImageView pandarosu;

    @FXML
    private TextField numarcard;

    @FXML
    private Label labeldonatii;

    @FXML
    private TextField numedonator;

    @FXML
    private TextField suma;

    @FXML
    private Button donare;

    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pandarosuFile = new File("Donatie/pandarosu.jpg");
        Image pandarosuImage = new Image(pandarosuFile.toURI().toString());
        pandarosu.setImage(pandarosuImage);
    }

    public void facereDonatie(ActionEvent event) {
        if (numarcard.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();
            Integer suma_donata = Integer.parseInt(suma.getText());
            String suma = "SELECT Suma FROM card_bancar WHERE Numarul = '" + numarcard.getText() + "'";
            Integer sumas = null;
            try {
                Statement statement = connectDB.createStatement();
                ResultSet suma_s = statement.executeQuery(suma);
                while (suma_s.next()) {
                    sumas = suma_s.getInt("Suma");


                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

            if (sumas - suma_donata > 0) {
                String verifyPayment = "UPDATE card_bancar SET Suma = (Suma - '" + suma_donata + "') WHERE Numarul = '" + numarcard.getText() + "'";


                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(verifyPayment);
                    labeldonatii.setText("Multumim pentru donatie!");
                    loadData();

                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }


            } else
                labeldonatii.setText("Fonduri insuficiente :( ");
        }


    }

    void loadData()
    {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();
        Integer suma_donata = Integer.parseInt(suma.getText());

        String sumad = "INSERT INTO donatii (nume, sumadonata) VALUES ('" + numedonator.getText() + "', '" + suma_donata + "')";

        try {
            PreparedStatement preparedStmt = connectDB.prepareStatement(sumad);
            preparedStmt.execute();


        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}