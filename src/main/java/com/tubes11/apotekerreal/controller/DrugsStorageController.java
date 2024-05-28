package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.dao.DoctorDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DrugsStorageController {
    @FXML
    private ImageView storageImageView;
    @FXML
    private TextField drugsNameTextField;
    @FXML
    private Button drugStorageSearchButton;
    @FXML
    private ListView drugsStorageListView;
    @FXML
    private ScrollBar drugStorageScrollBar;
    @FXML
    private Button drugsStorageBackButton;

    @FXML
    private void initialize(){
        String file_dir = "src/main/resources/com/tubes11/apotekerreal/img/apotek_try2.jpg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        storageImageView.setImage(bgImage);
    }
    @FXML
    private void drugsStorageBackButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void drugsNameTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNameTextField.getScene().getWindow();
        stage.close();
    }
}
