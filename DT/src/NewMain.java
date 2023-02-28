
import entités.Commande;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.CRUDCommande;
import utils.MyConnection;



import java.util.*;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class NewMain {

   
    public static void main(String[] args) {
   
        String to = "wiembenali111@gmail.com";        
        String from = "amirabenhenda2s2@gmail.com";
        //String host = "localhost";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        
        /*Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);*/
        
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication("amirabenhenda2s2@gmail.com", "rero ksxw habp lrws");
            }
});
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("this is the subject line !");
            message.setText("This is the test mail !");
            Transport.send(message);
            System.out.println("Sent message successfully..... !!");
            }catch(MessagingException mex){
                mex.printStackTrace();
            }
        
        
        /* MyConnection connexion = MyConnection.getInstance();    
        //Commande C = new Commande (1111,22222,33333,now(), "Echange", "disponible");
        /*ObservableList<Commande> list = FXCollections.observableArrayList();
        list.add(new Commande (0,0,0 , now(),"achat","disponible"));
        list.add(new Commande (1,1,1 , now(),"achat","disponible"));
        list.add(new Commande (2,2,2 , now(),"achat","disponible"));
        list.add(new Commande (3,3,3 , now(),"achat","disponible"));
        list.add(new Commande (4,4,4 , now(),"achat","disponible"));*/

        //CRUDCommande crudcommande = new CRUDCommande ();
        //crudcommande.AfficherC2();
        
        //CRUDCommande Cc = new CRUDCommande();
        //Cc.AfficherC();
        
    }
    
    }
    

