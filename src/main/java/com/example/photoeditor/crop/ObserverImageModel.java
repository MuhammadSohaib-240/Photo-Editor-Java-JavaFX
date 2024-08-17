package com.example.photoeditor.crop;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("All")
public class ObserverImageModel {
    private List<ImageObserver> observers = new ArrayList<>();
    private Image image;

    public void addObserver(ImageObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ImageObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Image croppedImage) {
        for (ImageObserver observer : observers) {
            observer.update(croppedImage);
        }
    }
}
