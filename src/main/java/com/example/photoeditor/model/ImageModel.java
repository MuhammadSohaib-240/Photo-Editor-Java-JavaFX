package com.example.photoeditor.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class ImageModel {
    private ObjectProperty<Image> image = new SimpleObjectProperty<>();
    private int width, height;

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    public void setImage(Image image) {
        this.image.set(image);
    }

    public Image getImage() {
        return image.get();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
