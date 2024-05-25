package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private ImageView bgImageView;

    @FXML
    private void initialize(){
        String file_dir = "/com/tubes11/apotekerreal/img/apotek_try2.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        bgImageView.setImage(bgImage);
    }


    @FXML
    private void userIdTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) userIdTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void passwordFieldOnAction(ActionEvent event){
        Stage stage = (Stage) passwordField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void nameTextFieldOnAction (ActionEvent event){
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void loginButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        // stage.setTitle("Apoteker Real");
        stage.show();
    }
}