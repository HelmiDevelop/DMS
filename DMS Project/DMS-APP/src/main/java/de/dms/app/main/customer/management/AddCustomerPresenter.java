/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.app.main.customer.management;

import com.helmidev.entities.Customer;
import com.helmidev.services.CustomerService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author mayel-1
 */
public class AddCustomerPresenter implements Initializable {

    @FXML
    private TextField customerFirstName;
    @FXML
    private TextField customerLastName;
    @FXML
    private TextField customerEmailAdress;
    @FXML
    private TextField customerAmount;
    @FXML
    private Button saveCustomer;

    @Inject
    CustomerService customerService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // inititialize 

        saveCustomer.setOnAction((ActionEvent event) -> {
            onCustomerSaveClick(event);
        });
    }

    public void onCustomerAddClick() {

    }

    private void onCustomerSaveClick(ActionEvent event) {
        Customer customer = new Customer();
        customer.setFirstname(this.customerFirstName.getText());
        customer.setLastname(this.customerLastName.getText());
        customer.setEmail(this.customerEmailAdress.getText());

        if (StringUtils.isEmpty(this.customerAmount.getText())) {
            customer.setAccount(0);
        } else {
            customer.setAccount(Double.valueOf(this.customerAmount.getText()));
        }
        try {
            this.customerService.addCustomer(customer);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Customer Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
            Logger.getLogger(AddCustomerPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(event.getSource().toString());
        System.out.println(this.customerFirstName.getText());
        System.out.println(this.customerLastName.getText());
        System.out.println(this.customerEmailAdress.getText());
        System.out.println(this.customerAmount.getText());
    }

}
