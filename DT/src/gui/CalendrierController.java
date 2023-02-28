/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CalendrierController implements Initializable {

    @FXML
    ChoiceBox<String> ChoiceBox;
    
    final String [] operation = {"Echange", "Achat" };
    

    @FXML
     DatePicker datePicker;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
        @Override
    public void initialize(URL url, ResourceBundle rb) {
            ChoiceBox.getItems().addAll(operation);
            ChoiceBox.setOnAction((event) -> {
                try {
                    this.getOperation(event);
                } catch (IOException ex) {
                    Logger.getLogger(CalendrierController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }    
 
    
    public void getOperation (ActionEvent event)  throws IOException{
        
        String MyOperation = (String) ChoiceBox.getValue();

    }

    @FXML
    void DatePicker(ActionEvent event) throws IOException {
        
                LocalDate localDate=datePicker.getValue();
        String pattern = "MMMM,dd,yyyy";
        String datePatter = localDate.format(DateTimeFormatter.ofPattern(pattern));
        
         Parent root=FXMLLoader.load(getClass().getResource("ConfirmerCommande.fxml"));
    	Scene scene= new Scene(root,800,500);
    	Stage primaryStage= new Stage();
    	primaryStage.setScene(scene);
        
    }

   
    
}
    

