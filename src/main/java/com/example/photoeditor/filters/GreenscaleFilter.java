package com.example.photoeditor.filters;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

@SuppressWarnings("All")
public class GreenscaleFilter implements Filters {
    @Override
    public Image applyFilter(Image image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        PixelReader pixelReader = image.getPixelReader();
        WritableImage filteredImage = new WritableImage(width, height);
        PixelWriter pixelWriter = filteredImage.getPixelWriter();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pixelReader.getColor(x, y);
                double red = 0.0;
                double green = color.getGreen();
                double blue = 0.0;
                double opacity = color.getOpacity();
                pixelWriter.setColor(x, y, new Color(red, green, blue, opacity));
            }
        }
        return filteredImage;
    }
}
