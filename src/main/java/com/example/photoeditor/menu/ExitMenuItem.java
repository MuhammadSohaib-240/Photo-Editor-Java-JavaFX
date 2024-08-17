package com.example.photoeditor.menu;

import javafx.scene.control.MenuItem;

@SuppressWarnings("All")
public class ExitMenuItem implements MenuItemFactory {
    @Override
    public MenuItem createMenuItem() {
        MenuItem newMenuItem = new MenuItem("Exit");
        return newMenuItem;
    }
}
