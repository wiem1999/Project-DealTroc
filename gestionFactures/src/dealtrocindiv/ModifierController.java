/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author brahmi
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField id_produit;
    @FXML
    private TextField type_facture;
    @FXML
    private Button update;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private Label id;
    String idF;
    Facture f = new Facture();
    FactureCRUD c = new FactureCRUD();

    /**
     * Initializes the controller class.
     */
    void initializeData(int id_facture) {
        id.setText(String.valueOf(id_facture));

        idF = String.valueOf(id_facture);
        System.out.println(idF);
        System.out.println("-----------1---------");
        f = c.afficherFactureUne(idF);
        System.out.println(idF);
        System.out.println(f.toString());
        System.out.println("--------2------");
        nom.setText(f.getNom());
        description.setText(f.getDescription());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void updateFacture2(ActionEvent event) {
        
        
          if (nom.toString().compareTo("") == 0 || description.toString().compareTo("") == 0 ) {
            Window o = update.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de remplir tous les champs !");
            alert.initOwner(o);
            alert.show();
            System.out.println("-----------------partie1-------------");

        } else {

        f.setNom(nom.getText());
        f.setDescription(description.getText());
        c.modifierFacture(f);

        Window o = update.getScene().getWindow();
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Confirmation");
        alert2.setContentText("Facture modifiée avec succés !");
        alert2.initOwner(o);
        alert2.show();}

    }

}
