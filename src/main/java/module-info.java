module com.example.projectfis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projectfis to javafx.fxml;
    exports com.example.projectfis;
}