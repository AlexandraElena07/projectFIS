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

public class BileteController implements Initializable {
    @FXML
    private TextField card;

    @FXML
    private Label labelBilete;

    @FXML
    private TextField nume;

    @FXML
    private Button adult;

    @FXML
    private Button copil;

    @FXML
    private Button back;

    @FXML
    private ImageView leu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File leuFile = new File("Bilete/leu.jpg");
        Image leuImage = new Image(leuFile.toURI().toString());
        leu.setImage(leuImage);
    }


    public void achizitionareBileteAdulti(ActionEvent event) {
        if (card.getText().isBlank() == false) {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            String suma = "SELECT Suma FROM card_bancar WHERE Numarul = '" + card.getText() + "'";
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

            if (sumas - 10 > 0) {

                String verifyPayment = "UPDATE card_bancar SET Suma = (Suma - 10) WHERE Numarul = '" + card.getText() + "'";

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(verifyPayment);
                    labelBilete.setText("Congrats!");
                    loadData("Adult");

                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }


            } else
                labelBilete.setText("Fonduri insuficiente :( ");


        }
    }

    public void achizitionareBileteCopl(ActionEvent event) {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String suma = "SELECT Suma FROM card_bancar WHERE Numarul = '" + card.getText() + "'";
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

        if (sumas - 5 > 0) {

            String verifyPayment = "UPDATE card_bancar SET Suma = (Suma - 5) WHERE Numarul = '" + card.getText() + "'";

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verifyPayment);
                labelBilete.setText("Congrats!");
                loadData("Copil");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }


        } else
            labelBilete.setText("Fonduri insuficiente :( ");


    }

    void loadData(String persoana)
    {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String sumad = "INSERT INTO bilete (nume, tip) VALUES ('" + nume.getText()  + "', '" + persoana  + "')";

        try {
            PreparedStatement preparedStmt = connectDB.prepareStatement(sumad);
            preparedStmt.execute();


        }catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}