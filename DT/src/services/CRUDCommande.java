/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnection;

/**
 *
 * @author Lenovo
 */
public class CRUDCommande implements Interface_Commande {

    
    Statement ste;
    Connection conn = MyConnection.getConnection();
    
    @Override
    public void AjouterC(Commande C) {
        
          try {
        
     
        ste = conn.createStatement();
        String req = "INSERT INTO `commande` VALUES ( '" + C.getId_commande()+ "','" + C.getId_utilisateur() + "', '" + C.getId_produit() + "', '" +C.getDate()+ "','"+ C.getRole() + "', '" + C.getStatus() + "')";
        ste.executeUpdate(req);
        System.out.println("Commande Ajoutée !!!");
    } catch (SQLException ex) {
        System.out.println("Commande n'est pas ajoutée, Veuillez réessayer ! ");
    }
        
    }
    
    
      @Override
    public void AjouterC2(Commande C) {
        
     try {
            String req = "INSERT INTO `commande` (`id_commande`, `id_utilisateur`,`ìd_produit`, `date`, `role`, ``Status) VALUES (" + C.getId_commande()+ "','" + C.getId_utilisateur()+ "','" +C.getId_produit()+ "','" + C.getDate()+ "','" + C.getRole() + "','" + C.getStatus() ;
            PreparedStatement ps=conn.prepareStatement(req);
          
            ps.setInt(1, C.getId_commande());
            ps.setInt(2, C.getId_utilisateur());
            ps.setInt(3, C.getId_produit());
            ps.setObject(1, C.getDate());
            ps.setString(4, C.getRole());
            ps.setString(5, C.getStatus());
             ps.executeUpdate();
            System.out.println("Commande ajoutée !");
        } catch (SQLException ex) {
            ex.printStackTrace();                    
        }   
        
    }
    
    
    @Override
    public void ModifierC(Commande C) {
      
         try {
            String req = "UPDATE `commande` SET `role` = '" + C.getRole()+ "' WHERE `commande`.`id_commande` = " + C.getId_commande();
            Statement st =conn.createStatement();
            st.executeUpdate(req);
            System.out.println("La commande a été mise à jour");
    } catch (SQLException ex) {
        System.out.println("La commande n'a pas été mise à jour, Veuillez réessayer !");
    }
     
    }   
        
        
    @Override
    public void SupprimerC(Commande C) {
      
         try {
            String req = "DELETE FROM `commande` WHERE `Commande`.`id_commande` = " + C.getId_commande();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande a été supprimée ! ");
        } catch (SQLException ex) {
            System.out.println("Commande n'a pas été supprimée, Veuillez réessay ! ");
        }   
        
    }

  

    @Override
    public ObservableList<Commande> AfficherC() {
       
        ObservableList<Commande> list = FXCollections.observableArrayList()  ;
       try {
           String req = "Select * from `commande` ";
           Statement st = conn.createStatement();
           ResultSet RS = st.executeQuery(req);
           while(RS.next()){
             Commande C = new Commande();
             C.setId_commande(RS.getInt(1));
             C.setId_utilisateur(RS.getInt(2));
             C.setId_produit(RS.getInt(3));          
             C.setRole(RS.getString(5));
             C.setStatus(RS.getString(6));
             list.add(C);
             for (Commande commande : list){
               System.out.println(commande);
           }
           }
       } catch (SQLException ex){
           System.out.println(ex.getMessage());
           System.out.println("La commande ne peut pas être affichée");
           ex.printStackTrace();
       }
        
       return list ;
    }
    
    
    public ObservableList<Commande> AfficherC2() {
          {
            ObservableList<Commande> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from `commande`";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Commande C = new Commande();
             C.setId_commande(RS.getInt(1));
             C.setId_utilisateur(RS.getInt(2));
             C.setId_produit(RS.getInt(3));          
             C.setRole(RS.getString(5));
             C.setStatus(RS.getString(6));
             list.add(C);
             for (Commande commande : list){
               System.out.println(commande);
           }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    }
    
    
    
}
  
    

