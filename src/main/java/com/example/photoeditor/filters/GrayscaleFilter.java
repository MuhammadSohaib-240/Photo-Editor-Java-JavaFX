package com.example.photoeditor.filters;

import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.utilities.Utilities;
import javafx.scene.image.Image;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

@SuppressWarnings("All")
public class GrayscaleFilter implements Filters{

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    @Override
    public Image applyFilter(Image image) {
        // LOADING IMAGE
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat img = imageToMatConvertor.convert(image);

        // GRAYSCALING IMAGE
        Mat grayscaledImage = new Mat();
        Imgproc.cvtColor(img, grayscaledImage, Imgproc.COLOR_BGR2GRAY);

        // SETTING IMAGE IN IMAGEVIEW
        return matToImageConvertor.convert(grayscaledImage);
    }
}
