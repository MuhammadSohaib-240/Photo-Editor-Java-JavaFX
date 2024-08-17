package com.example.photoeditor.navigation;

import com.example.photoeditor.model.ImageModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("All")
public abstract class BaseController implements Initializable {
    protected ImageModel imageModel;

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Action Perform
    }
}
