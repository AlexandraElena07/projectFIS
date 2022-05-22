package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerEventsController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Button stergere;

    @FXML
    private Button editare;

    @FXML
    private Button adaugare;

    @FXML
    private Button actualiare;

    @FXML
    private Button voturi;

    @FXML
    private ImageView pozaPonei;

    @FXML
    private TableView<Events> events;

    @FXML
    private TableColumn<Events, String> id;

    @FXML
    private TableColumn<Events, String> titlu;

    @FXML
    private TableColumn<Events, String> descriere;

    ObservableList<Events> oblist = FXCollections.observableArrayList();

    String query = null;

    ResultSet resultSet = null;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File poneiFile = new File("Evenimente/ponei.jpg");
        Image poneiImage = new Image(poneiFile.toURI().toString());
        pozaPonei.setImage(poneiImage);

        loadDate();
    }


    @FXML
    public void getAddView(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(AddController.class.getResource("addEvents.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Adăugare Eveniment");
            stage.show();


        } catch(IOException ex) {
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(DeleteController.class.getResource("deleteEvents.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Ștergere eveniment");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void edit(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(EditController.class.getResource("editEvents.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Editare Eveniment");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    public void votes(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(EditController.class.getResource("afisareVoturi.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Afișare voturi");
            stage.show();
        } catch(IOException ex) {
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }


    @FXML
    public void refteshTable(ActionEvent event) {
        try {
            oblist.clear();

            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet result = connectDB.createStatement().executeQuery("SELECT * FROM events");

            while(result.next()) {
                oblist.add(new Events(
                        result.getInt("id"),
                        result.getString("Titlu"),
                        result.getString("Descriere")));
                events.setItems(oblist);
            }
        } catch(SQLException ex) {
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);

        }

    }


    private void loadDate() {

        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM events");
            while(rs.next()) {
                oblist.add(new Events(rs.getInt("id"), rs.getString("Titlu"), rs.getString("Descriere")));
            }
        } catch (SQLException ex){
            Logger.getLogger(ManagerEventsController.class.getName()).log(Level.SEVERE,null,ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titlu.setCellValueFactory(new PropertyValueFactory<>("Titlu"));
        descriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));


        events.setItems(oblist);
    }



    public void switchTOMenuPersonal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("menuPersonal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Meniu Personal");
        stage.show();
    }



}
