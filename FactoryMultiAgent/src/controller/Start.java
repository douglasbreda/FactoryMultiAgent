/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author dougl
 */
public class Start implements Initializable {

    @FXML
    private Button btnStart;
    @FXML
    private Label txtPallets;
    @FXML
    private Label numPallet;
    @FXML
    private Label txtRobot;
    @FXML
    private Label numRobot;
    @FXML
    private Label txtMaxTruck;
    @FXML
    private Label numMaxTruck;
    @FXML
    private Label txtCurrentCharge;
    @FXML
    private Label numCurrent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert btnStart != null;
    }

    @FXML
    private void btnStart(ActionEvent event) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Teste");
        dialog.setHeaderText("Header");
        dialog.setContentText("Works");
        dialog.showAndWait();
    }

}
