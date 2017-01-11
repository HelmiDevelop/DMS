/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.app.main.customer.management;

import com.helmidev.entities.Customer;
import com.helmidev.services.CustomerService;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.inject.Inject;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mayel-1
 */
public class CustomerPresenter implements Initializable{
    
    @FXML private TableView customersTable;
    @FXML AnchorPane customerViewPanel;
    @FXML TableColumn<Customer, Integer> idcolumn;
    @FXML TableColumn<Customer, String> firstname;
    @FXML TableColumn<Customer, String> lastName;
    @FXML TableColumn<Customer, String> emailadr;
    @FXML TableColumn<Customer, Double> amount;
    
    
    @Inject
    CustomerService customerService;
    
    private ObservableList<Customer> customerData; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize buttons event
        idcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        emailadr.setCellValueFactory(new PropertyValueFactory<>("email"));
        amount.setCellValueFactory(new PropertyValueFactory<>("account"));
        customerData =  FXCollections.observableArrayList();
        customerData.addAll(customerService.getAllCustomer());
        customersTable.setItems(customerData);
        
        
    }
    
}
