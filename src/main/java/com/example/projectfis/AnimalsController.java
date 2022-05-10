package com.example.projectfis;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;

public class AnimalsController implements Initializable {
    @FXML
    private Button back;

    @FXML
    private Label titlu;

    @FXML
    private Label alpaca;
    @FXML
    private ImageView pozaAlpaca;
    @FXML
    private Label textAlpaca;

    @FXML
    private Label broasca;
    @FXML
    private ImageView pozaBroasca;
    @FXML
    private Label textBroasca;

    @FXML
    private Label cal;
    @FXML
    private ImageView pozaCal;
    @FXML
    private Label textCal;

    @FXML
    private Label cerb;
    @FXML
    private ImageView pozaCerb;
    @FXML
    private Label textCerb;

    @FXML
    private Label girafa;
    @FXML
    private ImageView pozaGirafa;
    @FXML
    private Label textGirafa;

    @FXML
    private Label leu;
    @FXML
    private ImageView pozaLeu;
    @FXML
    private Label textLeu;

    @FXML
    private Label paun;
    @FXML
    private ImageView pozaPaun;
    @FXML
    private Label textPaun;

    @FXML
    private Label ponei;
    @FXML
    private ImageView pozaPonei;
    @FXML
    private Label textPonei;

    @FXML
    private Label tigru;
    @FXML
    private ImageView pozaTigru;
    @FXML
    private Label textTigru;

    @FXML
    private Label urs;
    @FXML
    private ImageView pozaUrs;
    @FXML
    private Label textUrs;

    @FXML
    private Label vulpe;
    @FXML
    private ImageView pozaVulpe;
    @FXML
    private Label textVulpe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File alpacaFile = new File("imageAnimale/alpaca.jpg");
        Image alpacaImage = new Image(alpacaFile.toURI().toString());
        pozaAlpaca.setImage(alpacaImage);

        File broascaFile = new File("imageAnimale/broasca.jpg");
        Image broascaImage = new Image(broascaFile.toURI().toString());
        pozaBroasca.setImage(broascaImage);

        File calFile = new File("imageAnimale/cal.jpg");
        Image calImage = new Image(calFile.toURI().toString());
        pozaCal.setImage(calImage);

        File cerbFile = new File("imageAnimale/cerb.jpg");
        Image cerbImage = new Image(cerbFile.toURI().toString());
        pozaCerb.setImage(cerbImage);

        File girafaFile = new File("imageAnimale/girafa.jpg");
        Image girafaImage = new Image(girafaFile.toURI().toString());
        pozaGirafa.setImage(girafaImage);

        File leuFile = new File("imageAnimale/leu.jpg");
        Image leuImage = new Image(leuFile.toURI().toString());
        pozaLeu.setImage(leuImage);

        File paunFile = new File("imageAnimale/paun.jpg");
        Image paunImage = new Image(paunFile.toURI().toString());
        pozaPaun.setImage(paunImage);

        File poneiFile = new File("imageAnimale/ponei.jpg");
        Image poneiImage = new Image(poneiFile.toURI().toString());
        pozaPonei.setImage(poneiImage);

        File tigruFile = new File("imageAnimale/tigru.jpg");
        Image tigruImage = new Image(tigruFile.toURI().toString());
        pozaTigru.setImage(tigruImage);

        File ursFile = new File("imageAnimale/urs.jpg");
        Image ursImage = new Image(ursFile.toURI().toString());
        pozaUrs.setImage(ursImage);

        File vulpeFile = new File("imageAnimale/vulpe.jpg");
        Image vulpeImage = new Image(vulpeFile.toURI().toString());
        pozaVulpe.setImage(vulpeImage);

    }
}
