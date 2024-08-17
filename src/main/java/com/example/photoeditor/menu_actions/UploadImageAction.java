package com.example.photoeditor.menu_actions;

import com.example.photoeditor.model.ImageModel;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

@SuppressWarnings("All")
public class UploadImageAction implements Action{
    private ImageModel imageModel;

    public UploadImageAction(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        String path = file.toString().replaceAll("\\\\", "\\\\\\\\");
        Image image = new Image(path);
        imageModel.setImage(image);
    }
}
