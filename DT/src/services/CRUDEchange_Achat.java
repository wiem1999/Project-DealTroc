/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.Echange_Achat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author Lenovo
 */
public class CRUDEchange_Achat implements Interface_Echange_Achat {

    Statement ste;
    Connection conn = MyConnection.getConnection();

    @Override
    public void AjouterEA(Echange_Achat EA) {

        try {
        
     
        ste = conn.createStatement();
        String req = "INSERT INTO `echange` VALUES ( '" + EA.role+ "','" + EA.getId_operation() + "', '" + EA.getId_utilisateur() + "', '" +EA.getIdRDV()+ "','"+ EA.getPrix() + "', '" + EA.getRating()+ "')";
        ste.executeUpdate(req);
        System.out.println("Commande Ajoutée ");
    } catch (SQLException ex) {
        System.out.println("Commande n'est pas ajoutée ");
    }
}       
    
    

    @Override
    public void ModifierEA(Echange_Achat EA) {
    try {
        String req = "UPDATE `echange` SET `prix` = '" + EA.getPrix() + "' WHERE `id_utilisateur` = '" + EA.getId_utilisateur() + "' AND `id_operation` = '" + EA.getId_operation() + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(req);
        System.out.println("La commande a été mise à jour");
    } catch (SQLException ex) {
        System.out.println("La commande n'a pas été mise à jour, Veuillez réessayer !");
    }
}


    @Override
    public void SupprimerEA(Echange_Achat EA) {
       
      try {
            String req = "DELETE FROM `echange` WHERE `id_operation` = " +EA.getId_operation();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande a été supprimée ! ");
        } catch (SQLException ex) {
            System.out.println("Commande n'a pas été supprimée, Veuillez réessay ! ");
        }   
    }
    
    
    
    @Override
    public List<Echange_Achat> ConsulterEA() {
      
   List<Echange_Achat> EA = new ArrayList<Echange_Achat>();
          try {
       
        String req = "SELECT * FROM `echange` INNER JOIN `RDV` WHERE id_oporation= Echange.id_operation AND idRDV = RDV.idRDV ";
        ResultSet result = ste.executeQuery(req);
        
        while (result.next()) {
            Echange_Achat resultEA = new Echange_Achat(result.getString("role"),result.getInt("idRDV"),result.getInt("id_operation"), result.getInt("id_utilisateur"), result.getDouble("prix"), result.getString("rating"));
            EA.add(resultEA);
        }
        System.out.println(EA);
      
    } catch (SQLException ex) {
         System.out.println(ex);   
    }
   return EA;
    }
   
    }
    


