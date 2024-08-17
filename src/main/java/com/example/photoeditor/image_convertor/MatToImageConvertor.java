package com.example.photoeditor.image_convertor;

import javafx.scene.image.Image;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.ByteArrayInputStream;

@SuppressWarnings("All")
public class MatToImageConvertor implements ImageConvertor{
    @Override
    public Image convert(Mat frame) {
        MatOfByte buffer = new MatOfByte();
        Imgcodecs.imencode(".png", frame, buffer);
        return new Image(new ByteArrayInputStream(buffer.toArray()));
    }

    @Override
    public Mat convert(Image image) {
        return null;
    }
}
