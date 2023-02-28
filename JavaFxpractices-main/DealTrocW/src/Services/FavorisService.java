/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Entities.favoris;
import Util.MyConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class FavorisService implements Interfaces.InterfaceFavoris{
      MyConnection instance = MyConnection.getInstance(); 
     
    Connection cnx;
    
    
    
      @Override
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
      @Override
     public void supprimerf(favoris p) {
  String req = "delete from favoris where idf=?";

        try {
            PreparedStatement stm = MyConnection.getInstance().getConn().prepareStatement(req);
            stm.setInt(1, (int) p.getFIdProduit());
            int i = stm.executeUpdate();
            System.out.println(i + " produit suprimé du favoris");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
   
     public List<favoris> ConsulterlistFavoris() {
          
List<favoris> flist = new ArrayList<>();
        try {
            String req = "select * from favoris";
            Statement st = MyConnection.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                favoris f = new favoris();
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
                   f.setFimage(img);

                f.setFIdProduit(rs.getInt("idf"));
               f.setFtitre(rs.getString("titre"));
                f.setFdescription(rs.getString("description"));
                f.setFurl(rs.getString("url"));
                f.setFcategorie(rs.getString("categorie"));
                f.setFprix(rs.getInt("prix"));
                
              
                flist.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return flist;
        }

   

     
     

}
