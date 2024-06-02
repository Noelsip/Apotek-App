package com.tubes11.apotekerreal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.tubes11.apotekerreal.dao.DrugDAO;
import com.tubes11.apotekerreal.model.Drug;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePriceDrugsController {

    @FXML
    private ComboBox<String> drugsNameComboBox;
    @FXML
    private Button changePriceADrugBackButton, changePriceADrugHomeButton, changePriceButton;
    @FXML
    private TextField drugsNewPriceTextField;

    private DrugDAO drugDAO;
    private ObservableList<String> drugsNameList;

    public ChangePriceDrugsController() {
        drugDAO = new DrugDAO();
        drugsNameList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() throws SQLException {
        ObservableList<String> drugNames = FXCollections.observableArrayList();
        List<Drug> drugs = drugDAO.getAllDrugs();
        for (Drug drug : drugs) {
            drugNames.add(drug.getNamaObat());
        }
        drugsNameComboBox.setItems(drugNames);
    }

    @FXML
private void drugsNameComboBoxOnAction(ActionEvent event) throws SQLException{
    String selectedDrugName = drugsNameComboBox.getSelectionModel().getSelectedItem();
    if (selectedDrugName!= null) {
        List<Drug> drugs = drugDAO.getDrugByName(selectedDrugName);
        if (!drugs.isEmpty()) {
            Drug selectedDrug = drugs.get(0);
            drugsNewPriceTextField.setText(String.valueOf(selectedDrug.getHargaObat()));
        }
    }
}

    @FXML
    private void drugsNewPriceTextFieldOnAction(ActionEvent event){
        Stage stage = (Stage) drugsNewPriceTextField.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void changePriceButtonOnAction(ActionEvent event) throws SQLException {
        try {
            String drugName = drugsNameComboBox.getValue();
            double newPrice = Double.parseDouble(drugsNewPriceTextField.getText());
            Drug drug = new Drug();
            drug.setNamaObat(drugName);
            drug.setHargaObat(newPrice);
            drugDAO.updateDrug(drug);

            // Show success message box
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setHeaderText("Price Update Successful");
            successAlert.setContentText("The price of the drug has been updated successfully.");
            successAlert.showAndWait();
            System.exit(0);
        } catch (SQLException e) {
            // Show error message box
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error Updating Price");
            errorAlert.setContentText("Error updating the price of the drug: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void changePriceADrugBackButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void changePriceADrugHomeButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) changePriceADrugHomeButton.getScene().getWindow();
    
        stage.close();
    }
}