package com.example.photoeditor;

import com.example.photoeditor.controller.HomeController;
import com.example.photoeditor.model.ImageModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

@SuppressWarnings("All")
public class Main extends Application {

    private ImageModel imageModel = new ImageModel();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/photoeditor/view/HomeView.fxml"));
        Parent root1 = fxmlLoader.load();
        HomeController controller = fxmlLoader.getController();
        controller.setImageModel(imageModel);
        stage.setScene(new Scene(root1));
        stage.setTitle("Photo Editor");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}