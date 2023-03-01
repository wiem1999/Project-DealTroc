/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author brahmi
 */
public class FactureCRUD implements InterfaceCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    ObservableList<Facture> FacturestList = FXCollections.observableArrayList();

    @Override
    public void ajouterFacture() {

        try {

//          java.util.Date javaDate = new java.util.Date();
//             java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());  
            String req = " INSERT IGNORE INTO `facture`(id_produit) SELECT `IdProduit` FROM `echange` ";

            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Facture ajoutée!!!");
        } catch (SQLException ex) {
            System.out.println("Facture non ajoutée");
            ex.printStackTrace();
        }
    }

    public void ajouterFacture3(String id, int id2) {

        try {

//          java.util.Date javaDate = new java.util.Date();
//             java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());  
            String req = " INSERT IGNORE INTO `facture`(id_produit,id_type_facture) values (" + id + "," + id2 + ") ";

            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Facture ajoutée!!!");
        } catch (SQLException ex) {
            System.out.println("Facture non ajoutée");
            ex.printStackTrace();
        }
    }

    void ajouterFacture2(Facture f) {

        try {

//          
// String req = " Insert into personne values(0,'" + f.getNom() + "','" + f.getType_facture() + "','" + f.getDescription() + "','" + f.getId_produit() + "') ";
            java.util.Date javaDate = new java.util.Date();
            java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
            String req2 = " Insert into facture values(0,'" + f.getNom() + "','" + f.getType_facture() + "','" + mySQLDate + "','" + f.getId_produit() + "','" + f.getDescription() + "') ";
            ste = conn.createStatement();
            ste.executeUpdate(req2);
            System.out.println("Facture ajoutée!!!");
        } catch (SQLException ex) {
            System.out.println("Facture non ajoutée");
            ex.printStackTrace();
        }

    }

    @Override
    public void modifierFacture(Facture f) {
        try {
            String req = "UPDATE `facture` SET `description` = '" + f.getDescription() + "' ,`nom` = '" + f.getNom() + "' WHERE `id_facture` = " + f.getId_facture();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("facture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerFacture(int id) {
        try {
            String req = "DELETE FROM `facture` WHERE id_facture = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("facture deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Facture> afficherFacture() {
        ObservableList<Facture> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from facture";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                list.add(new Facture(RS.getInt(1), RS.getString(2), RS.getInt(3), RS.getDate(4), RS.getInt(5), RS.getNString(6)));

                System.out.println("pad de problème d'affichage");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("problème d'affichage");
            ex.printStackTrace();
        }

        return list;
    }

    public List<Facture> afficherFacture2() {
        {
            List<Facture> list = new ArrayList<>();
            try {
                String req = "Select * from facture";
                Statement st = conn.createStatement();

                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    Facture p = new Facture();
                    p.setNom(RS.getString("nom"));

                    list.add(p);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return list;
        }

    }

    public Facture afficherFactureUne(String id) {
        {
            Facture f = new Facture();
            try {
                String req = "Select * from facture where id_facture=" + id;
                Statement st = conn.createStatement();

                ResultSet RS = st.executeQuery(req);
                while (RS.next()) {
                    f.setId_facture(RS.getInt("id_facture"));
                    f.setNom(RS.getString("nom"));
                    f.setId_type_facture(RS.getInt("id_type_facture"));
                    f.setDate_facture(RS.getDate("date_facture"));
                    f.setId_produit(RS.getInt("id_produit"));
                    f.setDescription(RS.getString("description"));
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return f;
        }

    }

}
