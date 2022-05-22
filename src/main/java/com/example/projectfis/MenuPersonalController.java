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

public class MenuPersonalController implements Initializable {
    @FXML
    private Button editareEventsButton;

    @FXML
    private Button editareAnimaleButton;

    @FXML
    private Button votareButton;

    @FXML
    private Button donatiiButton;

    @FXML
    private Button bileteButton;

    @FXML
    private ImageView paunImage;

    @FXML
    private Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File paunFile = new File("ProiectFis/peacock.jpg");
        Image pImage = new Image(paunFile.toURI().toString());
        paunImage.setImage(pImage);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTOPoze(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("votarePoze.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Votarea pozelor");
        stage.show();
    }

    public void switchTOEvents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("eventsManager.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Evenimente");
        stage.show();
    }

    public void switchTOAnimals(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("animalsManager.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Animale");
        stage.show();
    }

    public void switchTODonatii(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("afisareDonatii.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Donații");
        stage.show();
    }

    public void switchTOBilete(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("afisareBilete.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Bilete");
        stage.show();
    }

}

