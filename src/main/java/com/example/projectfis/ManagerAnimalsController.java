package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerAnimalsController implements Initializable {
    @FXML
    private Button back;


    @FXML
    private Button stergere;

    @FXML
    private Button editare;

    @FXML
    private Label titlu;

    @FXML
    private ImageView pozaAlpaca;

    @FXML
    private ImageView pozaBroasca;

    @FXML
    private ImageView pozaCal;

    @FXML
    private ImageView pozaCerb;

    @FXML
    private ImageView pozaGirafa;

    @FXML
    private ImageView pozaLeu;

    @FXML
    private ImageView pozaPaun;

    @FXML
    private ImageView pozaPonei;

    @FXML
    private ImageView pozaTigru;

    @FXML
    private ImageView pozaUrs;

    @FXML
    private ImageView pozaVulpe;

    @FXML
    private ImageView pozaFlamingo;

    @FXML
    private TableView<Animals> animals;

    @FXML
    private TableColumn<Animals, String> id;

    @FXML
    private TableColumn<Animals, String> nume;

    @FXML
    private TableColumn<Animals, String> descriere;

    @FXML
    private TableColumn<Animals, String> regiune;

    @FXML
    private TableColumn<Animals, String> habitat;

    @FXML
    private TableColumn<Animals, String> tip;

    @FXML
    private TableColumn<Animals, String> conservare;

    String query = null;

    ResultSet resultSet = null;


    ObservableList<Animals> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle rs) {
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

        File flamingoFile = new File("imageAnimale/flamingo.jpg");
        Image flamingoImage = new Image(flamingoFile.toURI().toString());
        pozaFlamingo.setImage(flamingoImage);

        loadDate();
    }

    @FXML
    public void close(MouseEvent event) {

    }

    @FXML
    public void getAddView(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(AddController.class.getResource("addAnimals.fxml"));
            Stage stage= new Stage();
            Scene scene1 = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene1);
            stage.setTitle("Adaugare");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerAnimalsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(DeleteController.class.getResource("deleteAnimals.fxml"));
            Stage stage= new Stage();
            Scene scene1 = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene1);
            stage.setTitle("Stergere");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerAnimalsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void edit(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(EditController.class.getResource("editAnimals.fxml"));
            Stage stage= new Stage();
            Scene scene1 = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene1);
            stage.setTitle("Editare");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerAnimalsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void refteshTable(ActionEvent event) {
        try {
            oblist.clear();

            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet result = connectDB.createStatement().executeQuery("SELECT * FROM animale");

            while(result.next()) {
                oblist.add(new Animals(
                        result.getInt("id"),
                        result.getString("Nume"),
                        result.getString("Descriere"),
                        result.getString("Regiune"),
                        result.getString("Habitat"),
                        result.getString("Tip"),
                        result.getString("Conservare")));
                animals.setItems(oblist);
            }
        } catch(SQLException ex) {
            Logger.getLogger(ManagerAnimalsController.class.getName()).log(Level.SEVERE,null,ex);

        }

    }

    @FXML
    public void print(MouseEvent event) {

    }

    private void loadDate() {
        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM animale");
            while(rs.next()) {
                oblist.add(new Animals(rs.getInt("id"), rs.getString("Nume"), rs.getString("Descriere"), rs.getString("Regiune"), rs.getString("Habitat"), rs.getString("Tip"), rs.getString("Conservare")));
            }
        } catch (SQLException ex){
            Logger.getLogger(AnimalsController.class.getName()).log(Level.SEVERE,null,ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nume.setCellValueFactory(new PropertyValueFactory<>("Nume"));
        descriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));
        regiune.setCellValueFactory(new PropertyValueFactory<>("Regiune"));
        habitat.setCellValueFactory(new PropertyValueFactory<>("Habitat"));
        tip.setCellValueFactory(new PropertyValueFactory<>("Tip"));
        conservare.setCellValueFactory(new PropertyValueFactory<>("Conservare"));


        animals.setItems(oblist);
    }
}

