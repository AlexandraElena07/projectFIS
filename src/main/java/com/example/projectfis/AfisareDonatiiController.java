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

import java.io.File;
import java.io.IOException;
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

    @FXML
    private Button back;

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

    Parent root;
    Scene scene;
    Stage stage;

    public void switchTOMenuPersonal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("menuPersonal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Meniu Personal");
        stage.show();
    }
}
