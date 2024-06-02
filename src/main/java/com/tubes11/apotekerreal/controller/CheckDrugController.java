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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckDrugController {

    @FXML
    private ComboBox<String> drugsNameComboBox;
    @FXML
    private TextField drugsPriceTextField;
    @FXML
    private TextField drugAmountTextField;
    @FXML
    private Button loadButton;
    @FXML
    private Button backButton,homeButton;

    private ObservableList<String> drugsList = FXCollections.observableArrayList();
    private DrugDAO drugDAO = new DrugDAO();

    @FXML
    public void initialize() {
        try {
            // Retrieve the list of drug names from the DAO
            List<Drug> drugs = drugDAO.getAllDrugs();
            for (Drug drug : drugs) {
                drugsList.add(drug.getNamaObat());
            }
            drugsNameComboBox.setItems(drugsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadButtonOnAction(ActionEvent event) {
        String selectedDrug = drugsNameComboBox.getSelectionModel().getSelectedItem();
        if (selectedDrug != null) {
            // Retrieve the selected drug from the DAO
            List<Drug> drugs = drugDAO.getDrugByName(selectedDrug);
            if (!drugs.isEmpty()) {
                Drug drug = drugs.get(0);
                // Set the price and amount to the text fields
                drugsPriceTextField.setText(String.valueOf(drug.getHargaObat()));
                drugAmountTextField.setText(String.valueOf(drug.getJumlahObat()));
            }
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void homeButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) homeButton.getScene().getWindow();
    
        stage.close();
    }
}