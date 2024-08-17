package com.example.photoeditor.image_convertor;

import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

@SuppressWarnings("All")
public class ImageToMatConvertor implements ImageConvertor{
    @Override
    public Mat convert(Image image) {
        Image fxImage = image;
        int width = (int) fxImage.getWidth();
        int height = (int) fxImage.getHeight();
        int[] pixels = new int[width * height];
        PixelReader pixelReader = fxImage.getPixelReader();
        pixelReader.getPixels(0, 0, width, height, PixelFormat.getIntArgbInstance(), pixels, 0, width);

        Mat matImage = new Mat(height, width, CvType.CV_8UC3);
        byte[] data = new byte[width * height * 3];
        int pixelLength = 4; // Int size
        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];
            data[i * 3] = (byte) ((pixel >> 16) & 0xFF); // blue channel
            data[i * 3 + 1] = (byte) ((pixel >> 8) & 0xFF); // green channel
            data[i * 3 + 2] = (byte) (pixel & 0xFF); // red channel
        }
        matImage.put(0, 0, data);

        Imgproc.cvtColor(matImage, matImage, Imgproc.COLOR_BGR2RGB);

        return matImage;
    }

    @Override
    public Image convert(Mat frame) {
        return null;
    }
}
