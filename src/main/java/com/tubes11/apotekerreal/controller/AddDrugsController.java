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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddDrugsController {
    @FXML
    private ImageView bgImgVw;
    @FXML
    private TextField drugsAmountTextField;
    @FXML
    private TextField drugsPriceTextField;
    @FXML
    private TextField drugsNameTextField;
    @FXML
    private Button addDrugHomeButton;
    @FXML
    private Button addDrugBackButton;
    @FXML
    private Button addDrugButton;
    
    @FXML
    // To show the Image BackGround
    private void initialize(){
        String file_dir = "src/main/resources/com/tubes11/apotekerreal/img/img_try.jpeg";
        File file = new File(file_dir);

        Image bgImage = new Image(file.toURI().toString());
        bgImgVw.setImage(bgImage);
    }
    @FXML
    // Button Home
    private void homeButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader((getClass().getResource("/com/tubes11/apotekerreal/view/page/home.fxml")));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) addDrugHomeButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    // To TextField Controller Drug's Name
    private void drugsNameTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNameTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    // To TextField Controller Drug's Amount
    private void drugsAmountTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsAmountTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    // To TextField Controller Drug's price
    private void drugsPriceTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsPriceTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    //To MESSAGE AFTER BUTTON ADD IN ACTION
    private void addDrugButtonOnAction(ActionEvent event){
        String name = drugsNameTextField.getText();
        String amountText = drugsAmountTextField.getText();
        String priceText = drugsPriceTextField.getText();
        int amount = Integer.parseInt(amountText);
        double price = Double.parseDouble(priceText);
        Drug data = new Drug(name, amount, price);
        DrugDAO.addNewDrug(data);
        JOptionPane.showMessageDialog(null, "OBAT BERHASIL DITAMBAHKAN", "ADD DRUGS SCEDULE MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
    @FXML
    // Button Back Option Drugs
    private void dSceduleBackButtonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
