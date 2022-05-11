package com.example.projectfis;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.File;

public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;

    @FXML
    private Label welcomeText;

    @FXML
    private Label loginMessage;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView foxImageView;
    @FXML
    private ImageView giraffeImageView;
    @FXML
    private ImageView giraffe2ImageView;
    @FXML
    private TextField enterUsernameField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Button inregistrareButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile= new File("ProiectFis/tiger (2).jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File foxFile= new File("ProiectFis/fox.png");
        Image foxImage = new Image(foxFile.toURI().toString());
        foxImageView.setImage(foxImage);

        File giraffeFile= new File("ProiectFis/giraffe.png");
        Image giraffeImage = new Image(giraffeFile.toURI().toString());
        giraffeImageView.setImage(giraffeImage);

        File giraffe2File= new File("ProiectFis/giraffe2.png");
        Image giraffe2Image = new Image(giraffe2File.toURI().toString());
        giraffe2ImageView.setImage(giraffe2Image);
    }
    public void login(ActionEvent event)
    {

        if(enterUsernameField.getText().isBlank()==false && enterPasswordField.getText().isBlank()==false)
        {
            loginMessage.setText("Ai incercat sa te autentifici");
            validateLogin();
        }
        else
        {
            loginMessage.setText("Te rog introdu numele de utilizator si parola!");
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void inregistrareButtonOnAction(ActionEvent event) {
        //Stage stage = (Stage) inregistrareButton.getScene().getWindow();
        createAccountForm();

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void validateLogin() {
        DataBaseConnection connectNow= new DataBaseConnection();

        Connection connectDB= connectNow.getConnection();

        String verifyLogin= "SELECT count(1) FROM user_account WHERE username = '" + enterUsernameField.getText() + "'AND password = '" + enterPasswordField.getText() + "'";
        try {
            Statement statement= connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginMessage.setText("Congrats");
                } else {
                    loginMessage.setText("Invalid Login");
                }
            }


        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

    public void createAccountForm() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            Stage register_stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 520, 515);
            register_stage.initStyle(StageStyle.UNDECORATED);
            register_stage.setScene(scene);
            register_stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}