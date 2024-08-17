package com.example.photoeditor.menu;

import javafx.scene.control.MenuItem;

@SuppressWarnings("All")
public class OpenMenuItem implements MenuItemFactory {
    @Override
    public MenuItem createMenuItem() {
        MenuItem newMenuItem = new MenuItem("Open");
        return newMenuItem;
    }
}