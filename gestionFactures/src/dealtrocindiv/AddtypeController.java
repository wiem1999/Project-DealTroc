/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author brahmi
 */
public class AddtypeController implements Initializable {

    @FXML
    private TextField id_produit;
    @FXML
    private TextField type_facture;
    @FXML
    private Button fxajouter;
    private TextField nom;
    @FXML
    private TextField description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    Statement ste;
    Connection conx = MyConnection.getInstance().getConn();

    Facture f = new Facture();
    boolean type_trouvé = false;
   

    @FXML
    private void addfacture(ActionEvent event) {

        String type = type_facture.getText();
        // String n = nom.getText();
        String des = description.getText();

        if (type.compareTo("") == 0 || des.compareTo("") == 0) {
            //Window o = fxajouter.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de remplir tous les champs !");
            // alert.initOwner(o);
            alert.show();
            System.out.println("-----------------partie1-------------");

        } else {

            try {
                System.out.println("----------------fosst try------------------");
                ste = conx.createStatement();
                System.out.println("--------------cr stete-----------------");
                ResultSet rs = ste.executeQuery("SELECT * FROM type_facture where nom ='" + type + "' ");
                System.out.println("type trouvé!!!");
                if (rs.first()) {
                    type_trouvé = true;
                    // Window o = fxajouter.getScene().getWindow();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("error form");
                    alert.setContentText("Le type " +type+" existe déja !");
                    // alert.initOwner(o);
                    alert.show();
                    System.out.println("-----------------partie2-------------");
                } else {
                    // Window o = fxajouter.getScene().getWindow();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setContentText("Vous etes sur d'ajouter ce type");
                    // alert.initOwner(o);
                    alert.show();
                    System.out.println("-----------------partie3-------------");
                    

                    Type_factureCRUD pc = new Type_factureCRUD();
                    Type_facture t = new Type_facture(0,type,des);
                    pc.Ajouter(t);
                    ///Window o2 = fxajouter.getScene().getWindow();
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Confirmation");
                    alert2.setContentText("Type  ajouté avec succés !");
                    // alert2.initOwner(o2);
                    alert2.show();
                    System.out.println("-----------------partie4-------------");

                }

            } catch (SQLException ex) {
                System.out.println("type non trouvé (req )");
                ex.printStackTrace();

            }

        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FactureWindow1.fxml"));

    }

}
