package com.example.projectfis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AnimalsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnimalsApplication.class.getResource("animals.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 835 , 750);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setTitle("Lista Animale");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}