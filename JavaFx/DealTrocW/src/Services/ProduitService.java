/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Util.MyConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class ProduitService implements Interfaces.InterfaceProduit{
   
    MyConnection instance = MyConnection.getInstance(); 
     
    Connection cnx;
    
    @Override
    public void AjouterProduit(Produit p) {


               String requete2 = "INSERT INTO produit (url,Description,titre,Categorie,prix)"
                       + "VALUES(?,?,?,?,?)";
              try{
               PreparedStatement pst = new MyConnection().getConn().prepareStatement(requete2);
                    pst.setString(1, p.getUrl());
                    pst.setString(2, p.getDescription());
                    pst.setString(3, p.getTitre());
                    pst.setString(4, p.getCategorie());
                    pst.setInt(5,p.getPrix());


                  pst.executeUpdate();
                  System.out.println("votre Produit est ajouté");
                  
            } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }}
; //To change body of generated methods, choose Tools | Templates.

    @Override
    public void ConsulterProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> ConsulterlistProduit() {
List<Produit> plist = new ArrayList<>();
        try {
            String req = "select * from produit";
            Statement st = MyConnection.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Produit p = new Produit();
                ImageView img=new ImageView();
                Image image;
try{
     image=new Image(new FileInputStream(rs.getString("url")));
                 img.setImage(image);
                                  Effect DropShadow = new DropShadow();
                 img.setEffect(DropShadow);
                 img.setPreserveRatio(true);
                 img.setFitWidth(70);
                 img.setFitHeight(70);
}catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                   p.setImage(img);

                p.setIdProduit(rs.getInt("idProduit"));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString("Description"));
                p.setUrl(rs.getString("url"));
                p.setCategorie(rs.getString("Categorie"));
                p.setPrix(rs.getInt("Prix"));
                
              
                plist.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return plist;
        }

    @Override
    public void ModifierProduit(Produit p) {
 String updateStatement = "UPDATE produit SET titre= ? ,Description=? ,Categorie=? ,prix=? WHERE IdProduit=? ";

        try {
            PreparedStatement pre = MyConnection.getInstance().getConn().prepareStatement(updateStatement);
          
            pre.setString(1, p.getTitre());
            pre.setString(2, p.getDescription());
            pre.setString(3, p.getCategorie());

            pre.setInt(4, p.getPrix());
            pre.setInt(5,p.getIdProduit());
         //   pre.setString(4, p.getImage());
        
            pre.executeUpdate();
            System.out.println("Record Update successfully from database.:!!: ");
        } catch (SQLException m) {
            System.out.println(m.getMessage());
        }


    }

    @Override
    public void supprimer(Produit p) {
  String req = "delete from produit where idProduit=?";

        try {
            PreparedStatement stm = MyConnection.getInstance().getConn().prepareStatement(req);
            stm.setInt(1, (int) p.getIdProduit());
            int i = stm.executeUpdate();
            System.out.println(i + " produit suprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
    
      public void updateLikes(int productId, int likes) {
    String sql = "UPDATE produits SET likes = ? WHERE idProduit = ?";
    try (
     PreparedStatement pst = new MyConnection().getConn().prepareStatement(sql);) {
        pst.setInt(1, likes);
        pst.setInt(2, productId);
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
      public List<Produit> RandomSelectProduct(int n) {
    List<Produit> products = this.ConsulterlistProduit();
    List<Produit> selectedProducts = new ArrayList<>();
    Random random = new Random();
    int size = products.size();
    for (int i = 0; i < n && i < size; i++) {
        int index = random.nextInt(size - i);
        selectedProducts.add(products.get(index));
        products.set(index, products.get(size - i - 1));
    }
    return selectedProducts;
}

    }
    

