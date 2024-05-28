package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.dao.DrugDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DeleteDrugsController {
    @FXML
    private ImageView drugDeleteImg;
    @FXML
    private ComboBox drugsNameComboBox;
    @FXML
    private Button deleteDrugsButton;
    @FXML
    private ComboBox drugsAmountComboBox;
    @FXML
    private Button deleteDrugsBackButton;
    @FXML
    private Button drugsDeleteHomeButton;

    @FXML
    private void initialize(){
        String file_dir = "src/main/resources/com/tubes11/apotekerreal/img/img_try.jpeg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        drugDeleteImg.setImage(bgImage);
    }
    @FXML
    private void drugsDeleteHomeButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) drugsDeleteHomeButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void drugsNameComboBoxOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNameComboBox.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void drugsAmountComboBoxOnAction(ActionEvent event){
        Stage stage = (Stage) drugsAmountComboBox.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void deleteDrugsBackButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void addDoctorButtonOnAction(ActionEvent event) throws SQLException{
        String name = drugsNameComboBox.getSelectionModel().getSelectedItem().toString();
        DrugDAO.deleteDrug(name);
        JOptionPane.showMessageDialog(null, "OBAT BERHASIL DIHAPUS", "DELETE DRUGS MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
}
