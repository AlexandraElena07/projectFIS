package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;

public class MenuController implements Initializable {
    @FXML
    private Button donatiiButton;

    @FXML
    private Button bileteButton;

    @FXML
    private Button animaleButton;

    @FXML
    private Button evenimenteButton;

    @FXML
    private Button fotografiiButton;

    @FXML
    private ImageView paunImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File paunFile = new File("ProiectFis/peacock.jpg");
        Image pImage = new Image(paunFile.toURI().toString());
        paunImage.setImage(pImage);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTObilete(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("bilete.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Achiziționare de Bilete");
        stage.show();
    }

    public void switchTOdonatii(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("donatii.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Donații");
        stage.show();
    }

    public void switchTOanimals(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("animals.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Lista de Animale");
        stage.show();
    }

    public void switchTOevents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("events.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Lista de Evenimente");
        stage.show();
    }

    public void switchTOpoze(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("incarcarePoze.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Fotografii");
        stage.show();
    }


}


