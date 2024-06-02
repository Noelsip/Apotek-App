package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController {
    @FXML
    private ImageView bgImageView;
    @FXML
    private MFXButton doctorsMFXButton;
    @FXML
    private MFXButton drugMFXButton;
    @FXML
    private MFXButton historyMFXButton;
    @FXML
    private MFXButton backMFXButton;

    @FXML
    private void initialize(){
        String file_dir = "/com/tubes11/apotekerreal/img/apotek_try2.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        bgImageView.setImage(bgImage);
    }

    @FXML
    private void doctorsMFXButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/docter-menu.fxml")));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Doctor");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void drugMFXButtonOnAction (ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml")));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Drug");
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());

        stage.show();
    }
    @FXML
    private void backMFXButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/login.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
