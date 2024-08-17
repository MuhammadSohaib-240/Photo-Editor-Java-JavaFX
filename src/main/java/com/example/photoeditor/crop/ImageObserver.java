package com.example.photoeditor.crop;

import javafx.scene.image.Image;

@SuppressWarnings("All")
public interface ImageObserver {
    void update(Image croppedImage);
}
