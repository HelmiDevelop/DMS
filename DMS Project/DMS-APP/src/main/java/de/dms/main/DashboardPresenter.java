/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.main;

import de.dms.app.main.customer.management.CustomerConsumer;
import de.dms.app.main.customer.management.CustomerPresenter;
import de.dms.app.main.customer.management.CustomerView;
import de.dms.app.main.product.management.ProductPresenter;
import de.dms.app.main.product.management.ProductView;
import de.dms.start.DMSPreloader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * @author mayel-1
 */
public class DashboardPresenter implements Initializable {

    @FXML
    private Button btn_toolbar_createNewCustomer;
    @FXML
    private Button btnAddNewBilling;
    @FXML
    private Button btnViewAllBillings;

    @FXML
    private Button btnAddNewProduct;
    @FXML
    private Button btnViewAllProducts;

    @FXML
    private Button btnAddNewPackaging;
    @FXML
    private Button btnViewAllPackagings;

    @FXML
    private Button btnAddNewCustomer;
    @FXML
    private Button btnViewAllCustomers;
    @FXML
    private StackPane mainPanelAnchorPane;

    CustomerPresenter customerPresenter;
    ProductPresenter productPresenter;
    
    private Consumer<CustomerPresenter> customerconsumer;

    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        bundle = resources;        
        // set programmatically
        //btn_toolbar_createNewCustomer.setText(bundle.getString("lbl_btn_toolbar_createNewCustomer"));

        /*btn_toolbar_createNewCustomer.setOnAction((ActionEvent event) -> {
            onAddNewCustomer(event);
        });*/
        btnAddNewBilling.setOnAction((ActionEvent event) -> {
            onAddNewBilling(event);
        });
        btnViewAllBillings.setOnAction((ActionEvent actionEvent) -> {
            onViewAllBillings(actionEvent);
        });
        btnAddNewProduct.setOnAction((ActionEvent event) -> {
            onAddNewProduct(event);
        });
        btnViewAllProducts.setOnAction((ActionEvent event) -> {
            onViewAllProducts(event);
        });
        /*btnAddNewCustomer.setOnAction((ActionEvent actionEvent)->{
            onAddNewCustomer(actionEvent);
        });*/
        btnViewAllCustomers.setOnAction((ActionEvent event) -> {
            onViewAllCustomers(event);
        });
        btnAddNewPackaging.setOnAction((ActionEvent event) -> {
            onAddNewPackaging(event);
        });
        btnViewAllPackagings.setOnAction((ActionEvent event) -> {
            onViewAllPackagings(event);
        });
    }

    private void onAddNewBilling(ActionEvent event) {
        //TODO load add new billing view
        System.out.println(event.getSource().toString());
    }

    private void onViewAllBillings(ActionEvent event) {
        //TODO load Billings table View
        System.out.println(event.getSource().toString());
    }

    private void onAddNewProduct(ActionEvent event) {
        //TODO laod add new Product Table
        System.out.println(event.getSource().toString());
    }

    private void onViewAllProducts(ActionEvent event) {
        //TOD load product table.
        ProductView productView = new ProductView();
        Parent view = productView.getView();
        productPresenter = (ProductPresenter)productView.getPresenter();
        this.mainPanelAnchorPane.getChildren().clear();
        this.mainPanelAnchorPane.getChildren().add(view);
        System.out.println(event.getSource().toString());
    }

    /*private void onAddNewCustomer(ActionEvent event) {
        //TODO load add customer view
        AddCustomerView addCustomerView = new AddCustomerView();
        this.addCustomerPresenter = (AddCustomerPresenter) addCustomerView.getPresenter();
        this.mainPanelAnchorPane.getChildren().clear();
        this.mainPanelAnchorPane.getChildren().add(addCustomerView.getView());
        System.out.println(event.getSource().toString());
    }*/
    private void onViewAllCustomers(ActionEvent event) {
        //TODO load customer table
        CustomerView customerView = new CustomerView();
        Parent view = customerView.getView();       
        
        Consumer<Object> presenterConsumer = this::consume;
        customerView.getPresenter(presenterConsumer);
        this.mainPanelAnchorPane.getChildren().clear();
        this.mainPanelAnchorPane.getChildren().add(view);
        

        System.out.println(event.getSource().toString());
    }
    private void consume(Object presenter){
        if(presenter instanceof CustomerPresenter){
            this.customerPresenter = (CustomerPresenter)presenter;
            //customerPresenter.initializeCustomerTableView();
        }
        
    }

    private void onAddNewPackaging(ActionEvent event) {
        //TODO load add new packaging
        System.out.println(event.getSource().toString());
    }

    private void onViewAllPackagings(ActionEvent event) {
        //TODO load packaging table
        System.out.println(event.getSource().toString());
    }

}
