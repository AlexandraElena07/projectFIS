package com.example.projectfis;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

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

    @FXML
    private Label inregistrareMessage;

    @FXML
    private PasswordField parolaField;

    @FXML
    private PasswordField confirmareField;

    @FXML
    private Label parolaMessage;

    @FXML
    private TextField numeField;

    @FXML
    private TextField prenumeField;

    @FXML
    private TextField utilizatorField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File pandaFile = new File("Registerpics/panda.png");
        Image pandaPic = new Image(pandaFile.toURI().toString());
        pandaImage.setImage(pandaPic);

    }

    public void registerButtonOnAction(ActionEvent event)
    {
        if(parolaField.getText().equals(confirmareField.getText())) {
            registerUser();
           inregistrareMessage.setText("Contul a fost creat cu succes!");
            parolaMessage.setText("Parola este corecta!");
        } else {
            parolaMessage.setText("   Parolele nu corespund :(");
        }

    }

    public void anulareButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) anulareButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerUser() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connnectDB = connectNow.getConnection();

        String firstname = numeField.getText();
        String lastname = prenumeField.getText();
        String username = utilizatorField.getText();
        String password = parolaField.getText();

        String insertFields = "INSERT INTO user_account(lastname, firstname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String InsertToRegister = insertFields + insertValues;

        try {
            Statement statement = connnectDB.createStatement();
            statement.executeUpdate(InsertToRegister);

            inregistrareMessage.setText("Contul a fost creat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



}
