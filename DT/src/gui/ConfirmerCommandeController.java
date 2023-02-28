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
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ConfirmerCommandeController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> ChoiceBox;
  
    private final String [] operation = {"Echange", "Achat" };
    
    @FXML
    private Button confirmer;

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
        
        
    }


    @FXML
    void btnConfirmer(ActionEvent event) throws IOException {              
        Parent root=FXMLLoader.load(getClass().getResource("CommandeInterface.fxml"));
    	Scene scene= new Scene(root,800,500);
    	Stage primaryStage= new Stage();
    	primaryStage.setScene(scene);
        
    }

    
}
