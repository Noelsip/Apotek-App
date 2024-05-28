package com.tubes11.apotekerreal.controller;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class DrugsController {
    @FXML
    private ImageView drugsImageView;
    @FXML
    private Button addDrugsButton;
    @FXML
    private Button drugChangePriceButton;
    @FXML
    private Button drugsDeleteButton;
    @FXML
    private Button drugsStockButton;
    @FXML
    private Button backDrugsButton;

    @FXML
    private void initialize(){
        String file_dir = "src/main/resources/com/tubes11/apotekerreal/img/apotek_try2.jpg";
        File file = new File(file_dir);

        Image drugsImage = new Image(file.toURI().toString());
        drugsImageView.setImage(drugsImage);
    }
    @FXML
    private void addDrugsButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/add-drug.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void drugChangePriceButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/change-price-drug.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void drugsDeleteButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/delete-drug.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void drugsStockButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-storage.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void backDrugsButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
