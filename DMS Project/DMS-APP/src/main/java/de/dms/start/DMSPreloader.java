/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.start;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mayel-1
 */
public class DMSPreloader extends Preloader{
    private Stage preloaderStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
       this.preloaderStage = primaryStage;
 
       VBox loading = new VBox(20);
       loading.setMaxWidth(Region.USE_PREF_SIZE);
       loading.setMaxHeight(Region.USE_PREF_SIZE);
       loading.getChildren().add(new ProgressBar());
       loading.getChildren().add(new Label("Please wait..."));
 
       BorderPane root = new BorderPane(loading);
       Scene scene = new Scene(root);
 
       primaryStage.setWidth(800);
       primaryStage.setHeight(600);
       primaryStage.setScene(scene);
       primaryStage.show();
   }
 
   @Override
   public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
      if (stateChangeNotification.getType() == StateChangeNotification.Type.BEFORE_START) {
         preloaderStage.hide();
      }
   }
    
}
