/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;

import Entities.Promo;
import Util.MyConnection;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DisplayPromosController implements Initializable {

    @FXML
    private TextField searchbar;
    @FXML
    private ImageView image_update;

    @FXML
    private ImageView image_up;
    @FXML
    private ListView<Promo> promoListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<Promo> promoList = FXCollections.observableArrayList();
    try {
    String req = "SELECT titre, description, pourcentage, prix, date_Deb, date_fin, promo_prix FROM promo";
        PreparedStatement pst = MyConnection.getInstance().getConn().prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
        String titre = rs.getString("titre");
String description = rs.getString("description");
int pourcentage = rs.getInt("pourcentage");
float prix = (float) rs.getInt("prix");
Date date_Deb = rs.getDate("date_Deb");
Date date_fin = rs.getDate("date_fin");
int promo_prix = rs.getInt("promo_prix");
            
               
Promo promo = new Promo(titre, description, pourcentage, prix, date_Deb, date_fin, promo_prix);

            promoList.add(promo);
        }
        promoListView.setItems(promoList);
promoListView.setCellFactory(param -> new ListCell<Promo>() {
    @Override
    protected void updateItem(Promo promo, boolean empty) {
        super.updateItem(promo, empty);

        if (empty || promo == null || promo.getTitre() == null) {
            setText(null);
        } else {
            setText(promo.getTitre() + " -Description  : " + promo.getDescription() + " -OriginalPrice  : " + promo.getPrix()+ " Price After"+promo.getPourcentage()+" % discount is : " + promo.getPromoPrix());
        }
    }
});

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des promos : " + e.getMessage());
    }
    //  promoTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
      //  if (newSelection != null) {
        //    Lt.setText(newSelection.getTitre());
          //  Ld.setText(newSelection.getDescription());
            //Lc.setText(newSelection.getPourcentage());
            //Lp.setText(String.valueOf(newSelection.getPrix()));
           // File file = new File(newSelection.getUrl());
            //Image image = new Image(file.toURI().toString());
           // image_up.setImage(image);

    // Set cell values for each column
 
}


   

         

    

      }