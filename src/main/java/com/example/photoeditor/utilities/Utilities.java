package com.example.photoeditor.utilities;

import com.example.photoeditor.filename_dialog.FileNameDialog;
import com.example.photoeditor.image_convertor.ImageConvertor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.Optional;

@SuppressWarnings("All")
public class Utilities {

    public String path;
    public String fileName;

    private ImageConvertor matToImageConvertor;
    private ImageConvertor imageToMatConvertor;

    public Utilities(ImageConvertor matToImageConverter, ImageConvertor imageToMatConvertor) {
        this.matToImageConvertor = matToImageConvertor;
        this.imageToMatConvertor = imageToMatConvertor;
    }

    public void setMatToImageConverter(ImageConvertor matToImageConvertor) {
        this.matToImageConvertor = matToImageConvertor;
    }

    public void setImageToMatConverter(ImageConvertor imageToMatConvertor) {
        this.imageToMatConvertor = imageToMatConvertor;
    }

    private FileNameDialog fileNameDialog;

    public void setFileNameDialog(FileNameDialog fileNameDialog) {
        this.fileNameDialog = fileNameDialog;
    }

    public void saveImage(Image image, String saveLocation) {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat imageMat = imageToMatConvertor.convert(image);
            String location = saveLocation + fileName;
            Imgcodecs.imwrite(saveLocation + fileName, imageMat);
        } catch (Exception e) {
            System.out.println("Null Returned");
        }
    }

    public void saveFileName() {
        try {
            if (fileNameDialog != null) {
                Optional<String> result = fileNameDialog.showAndWait();
                result.ifPresent(name -> {
                    fileName = name + ".png";
                });
            }
        } catch (Exception e) {
            // PASS
        }
    }

    public void displayMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Box");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }
}
