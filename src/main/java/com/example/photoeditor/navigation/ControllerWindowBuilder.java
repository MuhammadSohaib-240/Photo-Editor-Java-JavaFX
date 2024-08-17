package com.example.photoeditor.navigation;

import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.model.ImageModel;
import com.example.photoeditor.utilities.Utilities;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("All")
// ControllerWindowBuilder.java
public class ControllerWindowBuilder<T> {
    private String fxmlPath;
    private String title;
    private ImageModel imageModel;

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    public ControllerWindowBuilder withFXMLPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
        return this;
    }

    public ControllerWindowBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ControllerWindowBuilder withImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        return this;
    }

    public <T extends BaseController> void open(Class<T> controllerClass) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            T controller = fxmlLoader.getController();
            controller.setImageModel(imageModel);

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.setX(500);
            stage.setY(400);
            stage.show();
        } catch (Exception e) {
            utilities.displayMessage("Null Exception Error",
                    "Please upload image first in order to apply any features!");
        }
    }
}

