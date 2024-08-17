package com.example.photoeditor.menu_actions;

import com.example.photoeditor.filename_dialog.FileNameDialog;
import com.example.photoeditor.filename_dialog.NullFileNameDialog;
import com.example.photoeditor.filename_dialog._FileNameDialog;
import com.example.photoeditor.model.ImageModel;
import com.example.photoeditor.utilities.Utilities;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("All")
public class SaveImageAction implements Action{
    private ImageModel imageModel;
    private Utilities utilities;

    private FileNameDialog fileNameDialog;

    public SaveImageAction(ImageModel imageModel, Utilities utilities) {
        this.imageModel = imageModel;
        this.utilities = utilities;
        this.fileNameDialog = new _FileNameDialog();
    }

    public void setFileNameDialog(FileNameDialog fileNameDialog) {
        this.fileNameDialog = fileNameDialog;
    }

    @Override
    public void execute() {
        DirectoryChooser dc = new DirectoryChooser();
        File selectSaveLocation = dc.showDialog(null);
        Path path = Paths.get(selectSaveLocation.getAbsolutePath());
        String saveLocation = path.toString() + "\\";
        utilities.setFileNameDialog(fileNameDialog);
        utilities.saveFileName();
        utilities.saveImage(imageModel.getImage(), saveLocation);
        utilities.displayMessage("File Saved Successfully!!!",
                "File has been saved successfully & file path is " + saveLocation + utilities.fileName);
    }
}
