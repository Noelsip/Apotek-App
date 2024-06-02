package com.tubes11.apotekerreal.controller;

import java.io.IOException;
import java.sql.SQLException;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AddDrugsController {
    @FXML
    private Button addDrugButton;
    @FXML
    private Button addDrugBackButton;
    @FXML
    private Button addDrugHomeButton;
    @FXML
    private TextField drugsNameTextField;
    @FXML
    private TextField drugsAmountTextField;
    @FXML
    private TextField drugsPriceTextField;
    @FXML
    private Label drugsDataLabel;
    @FXML
    private ImageView homeImg;

    private DrugDAO drugDAO;

    public AddDrugsController() {
        drugDAO = new DrugDAO();
    }

    @FXML
    private void drugsNameTextFieldOnAction(ActionEvent event) {
        Stage stage = (Stage) drugsNameTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void drugAmountTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsAmountTextField.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void drugsPriceTextFieldOnAction(ActionEvent event){
        drugsPriceTextField.setText(drugsPriceTextField.getText().replaceAll("[^0-9]", ""));
    }

    @FXML
    private void addDrugButtonOnAction(ActionEvent event) throws SQLException {
        String name = drugsNameTextField.getText();
        int amount = Integer.parseInt(drugsAmountTextField.getText());
        double price = Double.parseDouble(drugsPriceTextField.getText());

        Drug data = new Drug(0, name, amount, price);


        try {
            DrugDAO.addDrug(data);
            JOptionPane.showMessageDialog(null, "Drug added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding drug: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void addDrugBackButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void addDrugHomeButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) addDrugHomeButton.getScene().getWindow();
    
        stage.close();
    }
}