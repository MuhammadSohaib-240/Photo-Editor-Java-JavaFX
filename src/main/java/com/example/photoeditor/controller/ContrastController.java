package com.example.photoeditor.controller;

import com.example.photoeditor.color_enhancement.ColorEnhancement;
import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.model.ImageModel;
import com.example.photoeditor.navigation.BaseController;
import com.example.photoeditor.utilities.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import java.net.URL;
import java.util.ResourceBundle;

@SuppressWarnings("All")
public class ContrastController extends BaseController implements ColorEnhancement {

    @FXML
    Slider slider;

    @FXML
    TextField textField;

    Mat image = null;

    Image fxImage;

    private ImageModel model = new ImageModel();

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.setMin(0);
        slider.setMax(200);
        slider.setValue(100);

        textField.setText("100");

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                textField.setText(Integer.toString((int) Math.round(slider.getValue())));
            }
        });

        slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                execute(slider.getValue());
            }
        });
    }

    public void setImageModel(ImageModel imageModel) {
        this.model = imageModel;
        fxImage = model.getImage();
    }

    @Override
    public void execute(double value) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        image = imageToMatConvertor.convert(fxImage);
        Mat dest = new Mat(image.rows(), image.cols(), image.type());
        image.convertTo(dest, -1, value/100, 0);
        model.setImage(matToImageConvertor.convert(dest));
    }
}
