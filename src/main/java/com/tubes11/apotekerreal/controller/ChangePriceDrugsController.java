package com.tubes11.apotekerreal.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.tubes11.apotekerreal.dao.DrugDAO;
import com.tubes11.apotekerreal.model.Drug;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChangePriceDrugsController {
    @FXML
    private ImageView priceImageView;
    @FXML
    private TextField drugsNewPriceTextField;
    @FXML
    private ComboBox drugsNameCombobox;
    @FXML
    private Button changePriceADrugBackButton;
    @FXML
    private Button changePriceButton;
    @FXML
    private Button changePriceADrugHomeButton;

    @FXML
    private void initialize(){
        String file_dir = "src/main/resources/com/tubes11/apotekerreal/img/img_try.jpeg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        priceImageView.setImage(bgImage);
    }
    @FXML
    private void drugsNameComboboxOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNameCombobox.getScene().getWindow();
        stage.close();
    }
    private void drugsNewPriceTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNewPriceTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void changePriceButtonOnAction(ActionEvent event){
        String name = drugsNameCombobox.getSelectionModel().getSelectedItem().toString();
        int jumlahObat = Drug.getJumlahObat(name);
        String newPriceText = drugsNewPriceTextField.getText();
        Double newPrice = Double.parseDouble(newPriceText);
        Drug data = new Drug(name, jumlahObat , newPrice );
        DrugDAO.addNewDrug(data);
        JOptionPane.showMessageDialog(null, "HARGA BERHASIL DIGANTI", "CHANGE DRUG'S PRICE MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
    @FXML
    private void changePriceADrugBackButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void changePriceADrugHomeButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
