package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotesNameController implements Initializable {

    @FXML
    private ImageView leuImage;

    @FXML
    private Button save;

    @FXML
    private ComboBox<String> cbBox;

    @FXML
    private Label label;

    @FXML
    private Label labelvote;

    @FXML
    private Button cancelButton;

    ObservableList <String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brandingFile= new File("Evenimente/leu.jpg");
        Image leu = new Image(brandingFile.toURI().toString());
        leuImage.setImage(leu);

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {
            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM votes_name");
            while(rs.next()) {
                list.add(rs.getString("name"));

            }


        } catch (SQLException ex) {
            Logger.getLogger(VotesNameController.class.getName()).log(Level.SEVERE,null,ex);
        }

        cbBox.setItems(null);
        cbBox.setItems(list);
    }

    public void select() {
        String s = cbBox.getSelectionModel().getSelectedItem().toString();
        label.setText(s);
    }


    public void save(ActionEvent event) {

        if(cbBox.getSelectionModel().isEmpty() == false){
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDB = connectNow.getConnection();

            String verify = "UPDATE votes_name SET count = (count +1) WHERE name = '" + cbBox.getSelectionModel().getSelectedItem() + " '";


            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verify);
                labelvote.setText("Vă mulțumim pentru vot!");


            } catch (SQLException ex) {
                ex.printStackTrace();
                ex.getCause();
            }


        } else
            labelvote.setText("Vă rugăm să alegeți opțiunea dorită! ");
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}

