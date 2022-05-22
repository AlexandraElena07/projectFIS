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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotarePozeController implements Initializable {
    @FXML
    private TextField id;

    @FXML
    private Button votare;

    @FXML
    private Button actualizare;

    @FXML
    private Button back;

    @FXML
    private TableView<Poze> table;

    @FXML
    private TableColumn<Poze, Integer> idpoza;

    @FXML
    private TableColumn<Poze, String> nume;

    @FXML
    private TableColumn<Poze, String> path;

    @FXML
    private TableColumn<Poze, Integer> contor;

    ObservableList<Poze> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle rs) {
        afisare();
    }

    @FXML
    public void votare(ActionEvent event) {

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();


        String update=  "UPDATE poze set contor = (contor + 1) WHERE idpoza = '" + id.getText() + "';";

        try {
            Statement st = connectDB.createStatement();
            st.executeUpdate(update);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


   public void afisare() {
        try {
            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet rs = connectDB.createStatement().executeQuery("SELECT * FROM poze");
            while(rs.next()) {
                oblist.add(new Poze(rs.getInt("idpoza"),rs.getString("nume"), rs.getString("path") ,rs.getInt("contor")));

            }
        } catch (SQLException ex){
            Logger.getLogger(VotarePozeController.class.getName()).log(Level.SEVERE,null,ex);
        }

        idpoza.setCellValueFactory(new PropertyValueFactory<>("idpoza"));
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        path.setCellValueFactory(new PropertyValueFactory<>("path"));
        contor.setCellValueFactory(new PropertyValueFactory<>("contor"));

       table.setItems(oblist);

    }

    @FXML
    public void refreshTable(ActionEvent event) {
        try {
            oblist.clear();

            DataBaseConnection connectNow= new DataBaseConnection();
            Connection connectDB= connectNow.getConnection();

            ResultSet result = connectDB.createStatement().executeQuery("SELECT * FROM poze");

            while(result.next()) {
                oblist.add(new Poze(
                        result.getInt("idpoza"),
                        result.getString("nume"),
                        result.getString("path"),
                        result.getInt("contor")));
                table.setItems(oblist);
            }
        } catch(SQLException ex) {
            Logger.getLogger(VotarePozeController.class.getName()).log(Level.SEVERE,null,ex);

        }

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTOMenuPersonal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("menuPersonal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Meniu Personal");
        stage.show();
    }

}

