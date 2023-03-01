/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.stage.Window;

/**
 *
 * @author brahmi
 */
public class Type_factureCRUD {

    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();

    public void Ajouter(Type_facture t) {

        try {

            String req2 = " Insert into type_facture values(0,'" + t.getNom() + "','" + t.getDescription() + "') ";
            ste = conn.createStatement();
            ste.executeUpdate(req2);
            System.out.println("type Facture ajoutée!!!");
        } catch (SQLException ex) {
            System.out.println("type Facture non ajoutée");
            //ex.printStackTrace();
            /// Window o = fxajouter.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("type existant !");
            //alert.initOwner(o);
            alert.show();
        }
    }

    void supprimerType(int id) {
          try {
            String req = "DELETE FROM `type_facture` WHERE id_type_facture = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("type deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
