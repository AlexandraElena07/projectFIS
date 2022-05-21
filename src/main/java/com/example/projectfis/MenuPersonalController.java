package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File paunFile = new File("ProiectFis/peacock.jpg");
        Image pImage = new Image(paunFile.toURI().toString());
        paunImage.setImage(pImage);
    }


}
