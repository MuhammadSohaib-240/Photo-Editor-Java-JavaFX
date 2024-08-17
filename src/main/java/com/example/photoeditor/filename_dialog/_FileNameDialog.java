package com.example.photoeditor.filename_dialog;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class _FileNameDialog implements FileNameDialog{
    @Override
    public Optional<String> showAndWait() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Output File Name");
        dialog.setHeaderText("Enter file name:");
        dialog.setContentText("File Name:");
        return dialog.showAndWait();
    }
}
