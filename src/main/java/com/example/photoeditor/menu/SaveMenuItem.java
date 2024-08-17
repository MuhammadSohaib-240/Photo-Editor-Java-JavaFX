package com.example.photoeditor.menu;

import javafx.scene.control.MenuItem;

@SuppressWarnings("All")
public class SaveMenuItem implements MenuItemFactory {
    @Override
    public MenuItem createMenuItem() {
        MenuItem newMenuItem = new MenuItem("Save");
        return newMenuItem;
    }
}
