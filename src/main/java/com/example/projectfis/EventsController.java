package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.Event;

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
    private TableView<Events> events;

    @FXML
    private TableColumn<Events, String> id;

    @FXML
    private TableColumn<Events, String> titlu;

    @FXML
    private TableColumn<Events, String> descriere;

    ObservableList<Events> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            try {
                DataBaseConnection connectNow= new DataBaseConnection();
                Connection connectDB= connectNow.getConnection();

                ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM events");
                while(rs.next()) {
                    oblist.add(new Events(rs.getString("id"), rs.getString("Titlu"), rs.getString("Descriere")));
                }
            } catch (SQLException ex){
                Logger.getLogger(EventsController.class.getName()).log(Level.SEVERE,null,ex);
            }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        titlu.setCellValueFactory(new PropertyValueFactory<>("Titlu"));
        descriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));


        events.setItems(oblist);
    }
}
