package com.helmidev.appdms;

import com.helmidev.entities.Category;
import com.helmidev.entities.Customer;
import com.helmidev.jpacontrollers.exceptions.IllegalOrphanException;
import com.helmidev.jpacontrollers.exceptions.NonexistentEntityException;
import com.helmidev.services.CategoryService;
import com.helmidev.services.CustomerService;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        createCustomer();
        launch(args);
    }   
    private static CategoryService categoryService;
    private static CustomerService customerService;
    private static void createCategory(){
        categoryService = new CategoryService();
        Category category = categoryService.findCategoryByName("Getraenke");
        
        try {
            categoryService.removeCategory(category);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
    }
    
    private static void createCustomer() throws Exception{
        customerService = new CustomerService();
        Customer customer = customerService.findCustomerByEmail("suzanne@email.com");
        customer.setEmail("suzannAAA@email.com");
        customerService.updateCustomer(customer);
    }
    
    

}
