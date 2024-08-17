module com.example.photoeditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencv;


    opens com.example.photoeditor to javafx.fxml;
    exports com.example.photoeditor;
    exports com.example.photoeditor.controller;
    opens com.example.photoeditor.controller to javafx.fxml;
}