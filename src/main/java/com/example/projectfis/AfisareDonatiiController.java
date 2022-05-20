package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AfisareDonatiiController implements Initializable {

    @FXML
    private ImageView poza;

    @FXML
    private TableView<Donatii> table;

    @FXML
    private TableColumn<Donatii, Integer> id;

    @FXML
    private TableColumn<Donatii, String> nume;

    @FXML
    private TableColumn<Donatii, Integer> sumadonata;

    ObservableList<Donatii> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File animalFile = new File("afisareDonatie/animal.jpg");
        Image animalImage = new Image(animalFile.toURI().toString());
        poza.setImage(animalImage);

        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM donatii");
            while(rs.next()) {
                oblist.add(new Donatii(rs.getInt("id"),rs.getString("nume"),rs.getInt("sumadonata")));
                table.setItems(oblist);
            }
        } catch (SQLException ex){
            Logger.getLogger(AfisareDonatiiController.class.getName()).log(Level.SEVERE,null,ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        sumadonata.setCellValueFactory(new PropertyValueFactory<>("sumadonata"));



    }
}