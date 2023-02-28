/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entités.Commande;
import java.net.URL;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.CRUDCommande;
import utils.MyConnection;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CommandeInterfaceController implements Initializable {

    @FXML
    private TextField id_commande;
    @FXML
    private TextField id_utilisateur;
    @FXML
    private TextField id_produit;
    @FXML
    private DatePicker date;
    @FXML
    private TextField role;
    @FXML
    private TextField status;
    @FXML
    private TableView<Commande> tableview;
    @FXML
    Button Ajouter;
    @FXML
    Button Modifier;
    @FXML
    Button Supprimer;
    @FXML
    private TableColumn<Commande, Integer> idCommandeCol;
    @FXML
    private TableColumn<Commande, Integer> idUtilisateurCol;
    @FXML
    private TableColumn<Commande, Integer> idProduitCol;
    @FXML
    private TableColumn<Commande, LocalDate> idDateCol;
    @FXML
    private TableColumn<Commande, String> idRoleCol;
    @FXML
    private TableColumn<Commande, String> idStatusCol;
    
    ObservableList<Commande> list = FXCollections.observableArrayList();
    @FXML
    Button Afficher;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCommandeCol.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_commande"));
        idUtilisateurCol.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_utilisateur"));
        idProduitCol.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_produit"));
        idDateCol.setCellValueFactory(new PropertyValueFactory<Commande, LocalDate>("date"));
        idRoleCol.setCellValueFactory(new PropertyValueFactory<Commande, String>("role"));    
        idStatusCol.setCellValueFactory(new PropertyValueFactory<Commande, String>("status"));
        tableview.setItems(list);
    }    

    @FXML
    void Ajouter(ActionEvent event) {

        if ( id_commande.getText().isEmpty() || 
                id_commande.getText().isEmpty() || 
                id_produit.getText().isEmpty() || 
                date.getValue().equals(date) || 
                role.getText().isEmpty() || 
                status.getText().isEmpty()) {
          
            String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            (new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Ajout non réussi";
                message = "Commande n'est pas ajoutée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                
                    tray.showAndDismiss(Duration.millis(3000));
            
            /*Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informations Insuffisantes");
            alert.setHeaderText("Veuillez remplir tous les champs !");
            alert.setContentText("Tous les champs doivent être remplis");
            alert.showAndWait();
            return ;*/
        
        }
        
        Commande commande = new Commande();
        commande.setId_commande(Integer.parseInt(id_commande.getText()));
        commande.setId_utilisateur(Integer.parseInt(id_utilisateur.getText()));
        commande.setId_produit(Integer.parseInt(id_produit.getText()));
        commande.setDate(date.getValue());
        commande.setRole(role.getText());       
        commande.setStatus(status.getText());  
        
       
        ObservableList<Commande> commandes = tableview.getItems();
        commandes.add(commande);
        
        id_commande.clear();
        id_utilisateur.clear();
        id_produit.clear();
        date.setValue(null);
        role.clear();
        status.clear();
        
        CRUDCommande Cc = new CRUDCommande();
        Cc.AjouterC(commande);

            String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            (new Alert(Alert.AlertType.CONFIRMATION, "Commande ajoutée avec succès", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Ajout réussi";
                message = "Commande ajoutée avec succès";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                
                    tray.showAndDismiss(Duration.millis(3000));
                    
                    
        String clientEmail = "rim20wertani@gmail.com";
        sendEmailConfirmer(clientEmail);
        
        }
        

    @FXML
    void Modifier(ActionEvent event) {        
               
    if (tableview.getSelectionModel().isEmpty()) {
       
            String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            (new Alert(Alert.AlertType.ERROR, "Veuillez sélectionner une commande à modifier", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Mise à jour n'est pas réussie";
                message = "Commande n'est pas modifiée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                
                    tray.showAndDismiss(Duration.millis(3000));
        
        /*Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner une commande à modifier");
        alert.showAndWait();*/
        
        
        return;
    }

    Commande c = tableview.getSelectionModel().getSelectedItem();
   
    c.setRole(role.getText());
   
    CRUDCommande Cc = new CRUDCommande (); 
    Cc.ModifierC(c);
    role.clear();
        tableview.refresh();
        
      String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            
                (new Alert(Alert.AlertType.CONFIRMATION, "La commande est modifiée avec succès ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Mise à jour réussie";
                message = "Commande modifiée avec succès";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                
                    tray.showAndDismiss(Duration.millis(3000));
    }

    @FXML
    void Supprimer(ActionEvent event) {
        
               if (tableview.getSelectionModel().isEmpty()) {
            
             String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            (new Alert(Alert.AlertType.ERROR, "Veuillez sélectionner une commande à supprimer", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Suppression n'est pas réussie";
                message = "Commande n'est pas supprimée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                
                    tray.showAndDismiss(Duration.millis(3000));   
                  
                   /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une commande à supprimer");
            alert.showAndWait();*/
               
             } else {
            Commande c = tableview.getSelectionModel().getSelectedItem();
            tableview.getItems().remove(c);
            tableview.refresh();
            CRUDCommande Cc = new CRUDCommande();
            Cc.SupprimerC(c);
            
                String tilte;
                String message;
                TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;
                tray.setAnimationType(type);
          
                (new Alert(Alert.AlertType.CONFIRMATION, "La commande est supprimée avec success", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Suppression réussie";
                message = "Commande supprimée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));
                
                String clientEmail = "rim20wertani@gmail.com";
                sendEmailAnnuler(clientEmail);
           
             }

    }

    @FXML
    void Afficher(ActionEvent event) {

        CRUDCommande crudcommande = new CRUDCommande();
        ObservableList<Commande> list = crudcommande.AfficherC();
        tableview.setItems(list);
        
        
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
          
                (new Alert(Alert.AlertType.CONFIRMATION, "La liste des commandes est affichée", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Affichage réussi";
                message = "Liste des commandes est affichée";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                    
                    tray.showAndDismiss(Duration.millis(3000));
        
    }
    
    
    private void sendEmailConfirmer(String to) {
        String from = "amirabenhenda2s2@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
    
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("amirabenhenda2s2@gmail.com", "qzhg tuaw gpqz icsg");
            }
     });
    
    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Passage de commande");
        message.setText("Votre commande a été passer avec succes :) ! ");
        Transport.send(message);
        System.out.println("Sent message successfully.");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
        
    }
    
    
    
    private void sendEmailAnnuler(String to) {
        String from = "amirabenhenda2s2@gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
    
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("amirabenhenda2s2@gmail.com", "qzhg tuaw gpqz icsg");
            }
     });
    
    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Passage de commande");
        message.setText("Votre commande a été Annulée avec succes !");
        Transport.send(message);
        System.out.println("Sent message successfully.");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
}
}
    

