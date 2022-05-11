package com.example.projectfis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;




public class RegisterController implements Initializable {

    @FXML
    private ImageView pandaImage;

    @FXML
    private Button anulareButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pandaFile = new File("Registerpics/panda.png");
        Image pandaPic = new Image(pandaFile.toURI().toString());
        pandaImage.setImage(pandaPic);

    }

    public void anulareButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) anulareButton.getScene().getWindow();
        stage.close();
    }

}
