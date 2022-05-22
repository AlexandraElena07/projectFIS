package com.example.projectfis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AfisareVoturiController implements Initializable {

    @FXML
    private Button actualizare;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Name, Integer> count;

    @FXML
    private TableColumn<Name, Integer> id;

    @FXML
    private TableColumn<Name, String> name;

    @FXML
    private TableView<Name> table;

    @FXML
    private ImageView leu1Image;

    ObservableList<Name> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle rs) {
        File leuFile= new File("Evenimente/leu1.jpg");
        Image leu = new Image(leuFile.toURI().toString());
        leu1Image.setImage(leu);
        afisare();
    }


    public void afisare() {
        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM votes_name");
            while(rs.next()) {
                oblist.add(new Name(rs.getInt("id"),rs.getString("name"), rs.getInt("count")));

            }
        } catch (SQLException ex){
            Logger.getLogger(AfisareVoturiController.class.getName()).log(Level.SEVERE,null,ex);
        }

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));

        table.setItems(oblist);

    }

    @FXML
    public void refreshTable(ActionEvent event) {
        try {
            oblist.clear();

            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet result = connectDB.createStatement().executeQuery("SELECT * FROM votes_name");

            while(result.next()) {
                oblist.add(new Name(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("count")));
                table.setItems(oblist);
            }
        } catch(SQLException ex) {
            Logger.getLogger(AfisareVoturiController.class.getName()).log(Level.SEVERE,null,ex);

        }

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }

}
