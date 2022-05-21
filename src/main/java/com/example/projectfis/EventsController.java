package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.Event;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventsController implements Initializable {

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

    @FXML
    private Button votesButton;

    ObservableList<Events> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File poneiFile = new File("Evenimente/ponei.jpg");
        Image poneiImage = new Image(poneiFile.toURI().toString());
        pozaPonei.setImage(poneiImage);

        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM events");
            while(rs.next()) {
                oblist.add(new Events(rs.getInt("id"), rs.getString("Titlu"), rs.getString("Descriere")));
            }
        } catch (SQLException ex){
            Logger.getLogger(EventsController.class.getName()).log(Level.SEVERE,null,ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titlu.setCellValueFactory(new PropertyValueFactory<>("Titlu"));
        descriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));


        events.setItems(oblist);
    }

    public void votesButtonOnAction() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("votesName.fxml"));
            Stage stage= new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setTitle("Votarea Numelui");
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
