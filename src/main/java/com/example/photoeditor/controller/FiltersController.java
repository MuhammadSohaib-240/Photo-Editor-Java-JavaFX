package com.example.photoeditor.controller;

import com.example.photoeditor.filters.BluescaleFilter;
import com.example.photoeditor.filters.Filters;
import com.example.photoeditor.filters.GrayscaleFilter;
import com.example.photoeditor.filters.GreenscaleFilter;
import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.model.ImageModel;
import com.example.photoeditor.navigation.BaseController;
import com.example.photoeditor.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import org.opencv.core.Mat;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("All")
public class FiltersController extends BaseController {

    @FXML
    Button grayscaleButton;

    @FXML
    Button bluescaleButton;

    @FXML
    Button greenscaleButton;

    Mat image = null;
    Image fxImage;

    private ImageModel model = new ImageModel();

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    Filters grayscaleFilter = new GrayscaleFilter();
    Filters blueFilter = new BluescaleFilter();
    Filters greenFilter = new GreenscaleFilter();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grayscaleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Image originalImage = fxImage;
                model.setImage(grayscaleFilter.applyFilter(originalImage));
            }
        });

        bluescaleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Image originalImage = fxImage;
                model.setImage(blueFilter.applyFilter(originalImage));
            }
        });

        greenscaleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Image originalImage = fxImage;
                model.setImage(greenFilter.applyFilter(originalImage));
            }
        });
    }

    public void setImageModel(ImageModel imageModel) {
        this.model = imageModel;
        fxImage = model.getImage();
    }
}
