package com.example.photoeditor.controller;

import com.example.photoeditor.crop.ImageObserver;
import com.example.photoeditor.crop.ObserverImageModel;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("All")
public class CropController extends BaseController implements ImageObserver {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @FXML
    TextField widthField;

    @FXML
    TextField heightField;

    @FXML
    Button cropButton;

    Mat image = null;
    Image fxImage;

    private ImageModel model = new ImageModel();

    private ObserverImageModel observerImageModel = new ObserverImageModel();

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observerImageModel.addObserver(this);

        cropButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int width = Integer.parseInt(widthField.getText());
                    int height = Integer.parseInt(heightField.getText());
                    cropImage(width, height);
                } catch (Exception e) {
                    System.out.println("Invalid width or height");
                }
            }
        });
    }

    public void setImageModel(ImageModel imageModel) {
        this.model = imageModel;
        fxImage = model.getImage();

        model.setWidth((int)fxImage.getWidth());
        model.setHeight((int)fxImage.getHeight());

        widthField.setText(Integer.toString(model.getWidth()));
        heightField.setText(Integer.toString(model.getHeight()));
    }

    public void cropImage(int width, int height) {

        if (fxImage == null) {
            System.out.println("No image selected");
        }

        int x = (model.getWidth() - width) / 2;
        int y = (model.getHeight() - height) / 2;

        Rect roi = new Rect(x, y, width, height);
        Mat croppedMat = new Mat(imageToMatConvertor.convert(fxImage), roi);
        Image croppedImage = matToImageConvertor.convert(croppedMat);
        model.setWidth((int) croppedImage.getWidth());
        model.setHeight((int) croppedImage.getHeight());
        model.setImage(croppedImage);

        // Notify observers with the cropped image
        observerImageModel.notifyObservers(croppedImage);
    }

    @Override
    public void update(Image croppedImage) {
        // All the updated changes will handled
        // in this method.
    }
}
