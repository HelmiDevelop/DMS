/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.app.main.customer.management;

import com.helmidev.services.CustomerService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.inject.Inject;

/**
 *
 * @author mayel-1
 */
public class AddCustomerPresenter implements Initializable{
    
    @FXML
    private TextField customerFirstName;
    @FXML
    private TextField CustomerLastName;
    @FXML
    private TextField CustomerEmailAdress;
    @FXML
    private TextField customerAmount;
    

    @Inject
    CustomerService customerService;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // inititialize 
    }
    
    public void onCustomerAddClick(){
        
    }
    
}
