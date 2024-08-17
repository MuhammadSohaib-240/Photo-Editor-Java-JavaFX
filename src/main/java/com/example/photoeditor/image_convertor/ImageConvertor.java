package com.example.photoeditor.image_convertor;

import javafx.scene.image.Image;
import org.opencv.core.Mat;

@SuppressWarnings("All")
public interface ImageConvertor {
    Image convert(Mat frame);
    Mat convert(Image image);
}
