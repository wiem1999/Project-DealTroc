/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;

import Api.GenerateQRCode;
import Entities.Produit;
import Entities.Promo;
import Services.ProduitService;
import Util.MyConnection;
import com.google.zxing.WriterException;
import static dealtrocw.ProdGUIController.fc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierGUIController implements Initializable {

    @FXML
    private TextField searchbar;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfcat;
    @FXML
    private TextField tfprix;
    @FXML
    private ImageView image_up;
    @FXML
    private Button btnmodif;
    @FXML
    private ComboBox<Integer> comboid;
    
        public static FileChooser fc = new FileChooser();
    File selectedfile;
    String path;


    ProduitService ps = new ProduitService();
    Produit p= new Produit();
    @FXML
    private Button btb;
    @FXML
    private CheckBox checkDis;
    @FXML
    private TextField tfpourcentage;
    @FXML
    private DatePicker datedeb;
    @FXML
    private DatePicker datefin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
              checkDis.setSelected(false);
            // TODO
            String req="select IdProduit from produit";
            PreparedStatement pst = MyConnection.getInstance().getConn()
                    .prepareStatement(req);
            ResultSet rs=pst.executeQuery();
            ObservableList<Integer> id = null;
            List<Integer> list = new ArrayList<>();
            while(rs.next()){
             
             list.add(rs.getInt("IdProduit"));
            
            }
            id = FXCollections
                    .observableArrayList(list);
            comboid.setItems(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModifierGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void ModifierProduit(ActionEvent event) {
        
      //Integer prix= Integer.parseInt(tfprix.getText());
      try{
          ps.ModifierProduit(new Produit(comboid.getSelectionModel().getSelectedItem(),
                  tftitre.getText(),
                  tfdesc.getText(),
                  tfcat.getText(),
                  Integer.parseInt(tfprix.getText())));       
          
        JOptionPane.showMessageDialog(null, "Produit modifié");
         } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Le prix doit être un nombre entier");
    }
      
       
        
        
    }

    @FXML
    private void getId(MouseEvent event) {
        comboid.setOnAction(e ->{
            String req="select titre,Description ,Categorie ,prix from produit where IdProduit=?";
            try {
                    PreparedStatement pst = MyConnection.getInstance().getConn()
                    .prepareStatement(req);             
                    pst.setInt(1,(Integer)comboid.getSelectionModel().getSelectedItem());
                ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    tftitre.setText(rs.getString("titre"));
                    tfdesc.setText(rs.getString("Description"));
                    tfcat.setText(rs.getString("Categorie"));
                    tfprix.setText(rs.getString("prix"));

                 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModifierGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        tftitre.setText(p.getTitre());
        tfdesc.setText(p.getDescription());
        tfcat.setText(p.getCategorie());
        tfprix.setText(String.valueOf(p.getPrix()));

        
    }

    @FXML
    private void back(ActionEvent event)throws IOException{
        // Load the Favoris.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdGUI.fxml"));
        Parent root = loader.load();
    
    // Get the controller for the Favoris.fxml file
        ProdGUIController ProdController = loader.getController();
    
    // Display the loaded FXML file
        Scene scene = new Scene(root);
        Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void onCheckDisClicked(ActionEvent event) {
      if (checkDis.isSelected()) {
tfpourcentage.setDisable(false);
datedeb.setDisable(false);
datefin.setDisable(false);
} else {
tfpourcentage.setDisable(true);
datedeb.setDisable(true);
datefin.setDisable(true);
}
           
        
    }
    
    @FXML
    private void createPromotion(ActionEvent event) throws IOException, AddressException, MessagingException {
    // Retrieve the selected product's details
    Integer idProduit = comboid.getSelectionModel().getSelectedItem();
    String titre = tftitre.getText();
    String description = tfdesc.getText();
    String categorie = tfcat.getText();
    float prix = Integer.parseInt(tfprix.getText());
    
    // Retrieve the promotion percentage
    Integer pourcentage = checkDis.isSelected() ? Integer.parseInt(tfpourcentage.getText()) : 0;
    
    // Calculate the promotion price
    Integer promoPrix = (int) Math.round(prix * (100 - pourcentage) / 100.0);
        LocalDate startDate = datedeb.getValue();
    LocalDate endDate = datefin.getValue();

    if (startDate == null || endDate == null) {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une date de début et une date de fin pour la promotion");
        return;
    }
    if (startDate.isBefore(LocalDate.now())) {
        JOptionPane.showMessageDialog(null, "La date de début doit être postérieure à la date d'aujourd'hui");
        return;
    }
    
    try {
        // Insert the promotion into the Promo table
        String req = "INSERT INTO Promo ( titre, description, prix, categorie, pourcentage, promo_prix, date_Deb, date_fin) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = MyConnection.getInstance().getConn().prepareStatement(req);
        pst.setString(1, titre);
        pst.setString(2, description);
        pst.setInt(3, (int) prix);
        pst.setString(4, categorie);
        pst.setInt(5, pourcentage);
        pst.setInt(6, promoPrix);
        pst.setDate(7, java.sql.Date.valueOf(startDate));
        pst.setDate(8, java.sql.Date.valueOf(endDate));
        pst.executeUpdate();
        Promo j=new Promo(titre, description, pourcentage, prix,  java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate), promoPrix);
        
String path = "C:/Users/ASUS/Documents/qr/code.png";
try{
            GenerateQRCode.generateQRcode(j, path);
            } catch (WriterException e) {
    e.printStackTrace();
}
        JOptionPane.showMessageDialog(null, "Promotion créée");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la création de la promotion : " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Le pourcentage doit être un nombre entier");
    }
    
        // Send an email notification
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        String username = "Wiem.benali@esprit.tn";
        String password = "223JFT0335";
        String toEmail = "Wiembenali111@gmail.com";
        String subject = "New Promotion Added";
        String messageText = "A new promotion has been added: " + titre +" with a discount of "+ pourcentage +" %      Get IT NOW";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
            System.out.println("Email sent successfully.");
        
    
        


}

    

    }
