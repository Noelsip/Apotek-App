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



public class DoctorController {
    @FXML
    private ImageView doctorImageView;
    @FXML
    private Button addDoctorButton;
    @FXML
    private Button checkScheduleButton;
    @FXML
    private Button deleteDoctorButton;
    @FXML
    private Button backDoctorMenu;

    @FXML
    private void initialize(){
        String file_dir = "/com/tubes11/apotekerreal/img/docter_img.jpg";
        File file = new File(file_dir);

        Image doctorImage = new Image(file.toURI().toString());
        doctorImageView.setImage(doctorImage);
    }
    @FXML
    private void addDoctorButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/add-doctors.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void checkScheduleButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/check-scedule-doctors.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) checkScheduleButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void deleteDoctorButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/docter-page/delete-scedule.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) deleteDoctorButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void backDoctorMenuOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) backDoctorMenu.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
