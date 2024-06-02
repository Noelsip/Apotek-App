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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DeleteDrugsController {

    @FXML
    private ComboBox<String> drugsNameComboBox;

    @FXML
    private Button deleteDrugsButton;

    @FXML
    private Button deleteDrugsBackButton;

    @FXML
    private Button drugsDeleteHomeButton;

    @FXML
    private TextArea infromationTextArea;

    private ObservableList<String> drugsList = FXCollections.observableArrayList();

    public void initialize() {
        DrugDAO drugDAO = new DrugDAO();
        try {
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
    private void drugsNameComboBoxOnAction(ActionEvent event) {
        String selectedDrug = drugsNameComboBox.getSelectionModel().getSelectedItem();
        if (selectedDrug!= null) {
            DrugDAO drugDAO = new DrugDAO();
            List<Drug> drugs = drugDAO.getDrugByName(selectedDrug);
            if (!drugs.isEmpty()) {
                Drug drug = drugs.get(0);
                infromationTextArea.setText("Nama Obat: " + drug.getNamaObat() + "\nJumlah Obat: " + drug.getJumlahObat() + "\nHarga Obat: " + drug.getHargaObat());
                System.exit(0);
            } else {
                infromationTextArea.clear();
            }
        }
    }
    @FXML
    private void deleteDrugsButtonOnAction(ActionEvent event) {
        String selectedDrug = drugsNameComboBox.getSelectionModel().getSelectedItem();
        if (selectedDrug!= null) {
            try {
                DrugDAO.deleteDrug(selectedDrug);
                drugsList.remove(selectedDrug);
                drugsNameComboBox.getSelectionModel().clearSelection();
                infromationTextArea.clear();

                // Show success message box
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Drug deleted");
                alert.setContentText("The drug \"" + selectedDrug + "\" has been deleted successfully.");
                alert.showAndWait();

            } catch (SQLException e) {
                e.printStackTrace();

                // Show error message box
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed to delete drug");
                alert.setContentText("An error occurred while deleting the drug \"" + selectedDrug + "\": " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void deleteDrugsBackButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubes11/apotekerreal/view/drug-page/drug-menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void drugsDeleteHomeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) drugsDeleteHomeButton.getScene().getWindow();
    
        stage.close();
    }

}