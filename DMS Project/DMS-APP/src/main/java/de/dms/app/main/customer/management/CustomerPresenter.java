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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author mayel-1
 */
public class CustomerPresenter implements Initializable{
    // =======Add customer 
    @FXML private TextField customerFirstName;
    @FXML private TextField customerLastName;
    @FXML private TextField customerEmailAdress;
    @FXML private TextField customerAmount;
    @FXML Button saveCustomerButton;
    //=======End add customer
    //========Customer table=========
    @FXML private TableView customersTable;
    @FXML AnchorPane customerViewPanel;
    @FXML TableColumn<Customer, Integer> idcolumn;
    @FXML TableColumn<Customer, String> firstname;
    @FXML TableColumn<Customer, String> lastName;
    @FXML TableColumn<Customer, String> emailadr;
    @FXML TableColumn<Customer, Double> amount;
    
    private ObservableList<Customer> customerData;
    //========End customer table=============
    
    
    @Inject
    CustomerService customerService;
    
     

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        saveCustomerButton.setOnAction((ActionEvent event) -> {
            onCustomerSaveClick(event);
        });        
        initializeCustomerTableView();        
    }
    /**
     * initialize the customer list table and set data
     */
    private void initializeCustomerTableView(){
        
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        emailadr.setCellValueFactory(new PropertyValueFactory<>("email"));
        amount.setCellValueFactory(new PropertyValueFactory<>("account"));
        customerData =  FXCollections.observableArrayList();
        customerData.addAll(customerService.getAllCustomer());
        customersTable.setItems(customerData);
        
    }
    
    private void onCustomerSaveClick(ActionEvent event) {
        Customer customer = new Customer();
        customer.setFirst_name(this.customerFirstName.getText());
        customer.setLast_name(this.customerLastName.getText());
        customer.setEmail(this.customerEmailAdress.getText());
        

        if (StringUtils.isEmpty(this.customerAmount.getText())) {
            customer.setAccount(0);
        } else {
            customer.setAccount(Double.valueOf(this.customerAmount.getText()));
        }
        try {
            this.customerService.addCustomer(customer);
            initializeCustomerTableView();
            Alert info = new Alert(Alert.AlertType.CONFIRMATION);
            info.setTitle("Confirmation");
            info.setHeaderText("Speichern erfolgreich");
            String msg = String.format("Kunde %1s wurde hinzugefügt", customerFirstName.getText() + " "+customerLastName.getText());
            info.setContentText(msg);
            info.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });           
           
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
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
