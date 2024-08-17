package com.example.photoeditor.remove_background;

import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.utilities.Utilities;
import javafx.scene.image.Image;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

@SuppressWarnings("All")
public class RemoveBackground {

    private static RemoveBackground instance;

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    public static synchronized RemoveBackground getInstance() {
        if (instance == null) {
            instance = new RemoveBackground();
        }
        return instance;
    }

    public Image removeBackground(Mat image) {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);
        Mat binaryImage = new Mat();
        Imgproc.threshold(grayImage, binaryImage, 0, 255, Imgproc.THRESH_BINARY_INV + Imgproc.THRESH_OTSU);
        Mat mask = new Mat();
        Imgproc.cvtColor(binaryImage, mask, Imgproc.COLOR_GRAY2BGR);
        Mat foreground = new Mat();
        Core.bitwise_and(image, mask, foreground);
        return matToImageConvertor.convert(foreground);
    }
}

