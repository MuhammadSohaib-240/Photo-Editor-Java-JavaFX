package com.example.photoeditor.menu;

import javafx.scene.control.MenuItem;

@SuppressWarnings("All")
public class MenuItemsFactory {
    public static MenuItem createOpenMenuItem() {
        MenuItemFactory openMenuItemFactory = new OpenMenuItem();
        return openMenuItemFactory.createMenuItem();
    }

    public static MenuItem createSaveMenuItem() {
        MenuItemFactory saveMenuItemFactory = new SaveMenuItem();
        return saveMenuItemFactory.createMenuItem();
    }

    public static MenuItem createExitMenuItem() {
        MenuItemFactory exitMenuItemFactory = new ExitMenuItem();
        return exitMenuItemFactory.createMenuItem();
    }
}
