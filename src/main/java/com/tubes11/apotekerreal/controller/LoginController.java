package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;

import com.tubes11.apotekerreal.dao.Connector;
import com.tubes11.apotekerreal.dao.LoginDAO;
// import com.tubes11.apotekerreal.util.DatabaseConnection;

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
    private TextField userNameTextField;
    @FXML
    private TextField passwordField;
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
    private void userNameTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) userNameTextField.getScene().getWindow();
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
        String fullName = nameTextField.getText();
        String userId = userNameTextField.getText();
        String password = passwordField.getText();

        LoginDAO userDAO = new LoginDAO(Connector.getConnection());
        if (userDAO.isValidUser(fullName, userId, password)) {
            // user authenticated successfully, proceed to the next page
            FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml")));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            // authentication failed, display an error message
            System.out.println("Invalid username or password");
        }
    }
}