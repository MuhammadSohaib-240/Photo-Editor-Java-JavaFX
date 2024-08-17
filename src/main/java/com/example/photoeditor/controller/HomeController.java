package com.example.photoeditor.controller;

import com.example.photoeditor.image_convertor.ImageConvertor;
import com.example.photoeditor.image_convertor.ImageToMatConvertor;
import com.example.photoeditor.image_convertor.MatToImageConvertor;
import com.example.photoeditor.menu.MenuItemsFactory;
import com.example.photoeditor.menu_actions.ExitAction;
import com.example.photoeditor.menu_actions.MenuItemsActions;
import com.example.photoeditor.menu_actions.SaveImageAction;
import com.example.photoeditor.menu_actions.UploadImageAction;
import com.example.photoeditor.model.ImageModel;
import com.example.photoeditor.navigation.ControllerWindowBuilder;
import com.example.photoeditor.remove_background.RemoveBackground;
import com.example.photoeditor.utilities.Utilities;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import java.net.URL;

import java.util.ResourceBundle;

@SuppressWarnings("All")
public class HomeController implements Initializable {

    ////////////////////////////
    // CREATING FXML OBJECTS //
    //////////////////////////
    @FXML
    HBox imageViewLayout;

    @FXML
    ImageView imageView;

    @FXML
    MenuBar menuBar;

    @FXML
    Button brightnessButton;

    @FXML
    Button contrastButton;

    @FXML
    Button sharpnessButton;

    @FXML
    Button cropButton;

    @FXML
    Button filtersButton;

    @FXML
    Button removeBackgroundButton;

    MenuItemsActions menuItemsActions = new MenuItemsActions();

    private ImageModel imageModel = new ImageModel();

    RemoveBackground backgroundRemover = RemoveBackground.getInstance();

    private FileChooser fileChooser;

    ImageConvertor matToImageConvertor = new MatToImageConvertor();
    ImageConvertor imageToMatConvertor = new ImageToMatConvertor();
    Utilities utilities = new Utilities(matToImageConvertor, imageToMatConvertor);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //////////////////////////
        // DISPLAYING MENU BAR //
        ////////////////////////
        Menu fileMenu = new Menu("File");

        MenuItem openMenuItem = MenuItemsFactory.createOpenMenuItem();
        MenuItem saveMenuItem = MenuItemsFactory.createSaveMenuItem();
        MenuItem exitMenuItem = MenuItemsFactory.createExitMenuItem();

        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, exitMenuItem);

        menuBar.getMenus().addAll(fileMenu);

        //////////////////////////
        // MEUNU ITEMS ACTIONS //
        ////////////////////////
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                menuItemsActions.addAction(new UploadImageAction(imageModel));
                menuItemsActions.execute();
            }
        });

        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                menuItemsActions.addAction(new SaveImageAction(imageModel, utilities));
                menuItemsActions.execute();
            }
        });

        exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                menuItemsActions.addAction(new ExitAction());
                menuItemsActions.execute();
            }
        });

        //////////////////////////
        // NAVIGATION SIDE-BAR //
        ////////////////////////
        brightnessButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControllerWindowBuilder builder = new ControllerWindowBuilder()
                        .withFXMLPath("/com/example/photoeditor/view/BrightnessView.fxml")
                        .withTitle("Brightness Controller")
                        .withImageModel(imageModel);
                builder.open(BrightnessController.class);
            }
        });

        contrastButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControllerWindowBuilder builder = new ControllerWindowBuilder()
                        .withFXMLPath("/com/example/photoeditor/view/ContrastView.fxml")
                        .withTitle("Contrast Controller")
                        .withImageModel(imageModel);
                builder.open(ContrastController.class);
            }
        });

        sharpnessButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControllerWindowBuilder builder = new ControllerWindowBuilder()
                        .withFXMLPath("/com/example/photoeditor/view/SharpnessView.fxml")
                        .withTitle("Sharpness Controller")
                        .withImageModel(imageModel);
                builder.open(SharpnessController.class);
            }
        });

        filtersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControllerWindowBuilder builder = new ControllerWindowBuilder()
                        .withFXMLPath("/com/example/photoeditor/view/FiltersView.fxml")
                        .withTitle("Filters Controller")
                        .withImageModel(imageModel);
                builder.open(FiltersController.class);
            }
        });

        cropButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControllerWindowBuilder builder = new ControllerWindowBuilder()
                        .withFXMLPath("/com/example/photoeditor/view/CropView.fxml")
                        .withTitle("Crop Controller")
                        .withImageModel(imageModel);
                builder.open(CropController.class);
            }
        });

        imageView.imageProperty().bind(imageModel.imageProperty());
        imageView.setFitHeight(350);
        imageView.setFitWidth(400);

        removeBackgroundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeBackground();
            }
        });
    }

    public void removeBackground() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = imageToMatConvertor.convert(imageModel.getImage());
        Image fxImage = backgroundRemover.removeBackground(image);
        imageModel.setImage(fxImage);
    }


    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        imageView.imageProperty().bind(imageModel.imageProperty());
    }
}