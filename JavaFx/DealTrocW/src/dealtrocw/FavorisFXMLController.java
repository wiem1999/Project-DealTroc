/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;

import Entities.Produit;
import Entities.favoris;
import Services.FavorisService;
import Services.ProduitService;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FavorisFXMLController implements Initializable {
//twilio passwor v9A._J4*cN6A)ZQ10826399
    @FXML
    private TextField searchbar;
    @FXML
    private ImageView image_update;
    @FXML
    private Label Lt;
    @FXML
    private Label Ld;
    @FXML
    private Label Lc;
    @FXML
    private Label Lp;
    @FXML
    private Label labelLikes;
    
    
   //ProduitService ps = new ProduitService();
    FavorisService fs = new FavorisService();
    @FXML
    private Button btnsupp;
   
    @FXML
    private ImageView image_up;
   
    FavorisService ps = new FavorisService();
    @FXML
    private ListView<favoris> listF;

    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
        
        List<favoris> lf = ps.ConsulterlistFavoris();
        
        ObservableList<favoris> data1= FXCollections.observableArrayList(lf);

        listF.setItems(data1);
        
listF.setCellFactory(lv -> new ListCell<favoris>() {
    @Override
    protected void updateItem(favoris item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        } else {
            setText(item.getFtitre());
        }
    }
});
listF.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
        Lt.setText(newSelection.getFtitre());
        Ld.setText(newSelection.getFdescription());
        Lc.setText(newSelection.getFcategorie());
        Lp.setText(String.valueOf(newSelection.getFprix()));
        File file = new File(newSelection.getFurl());
        Image image = new Image(file.toURI().toString());
        image_up.setImage(image);
    }
});
        
        
     //   idcell1.setCellValueFactory(new PropertyValueFactory<>("idf"));
      //  titrecell1.setCellValueFactory(new PropertyValueFactory<>("titre"));
       // desccell1.setCellValueFactory(new PropertyValueFactory<>("description"));
        //catcell1.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        //prixcell1.setCellValueFactory(new PropertyValueFactory<>("prix"));

       // tabF.setItems(data1);
        
  
   //     tabF.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    //    if (newSelection != null) {
            // Update the labels and image view with the selected item's details
    //        Lt.setText(newSelection.getFtitre());
     //       Ld.setText(newSelection.getFdescription());
      //      Lc.setText(newSelection.getFcategorie());
       //     Lp.setText(String.valueOf(newSelection.getFprix()));
        //    File file = new File(newSelection.getFurl());
         //   Image image = new Image(file.toURI().toString());
          //  image_up.setImage(image);
        }
        
         // get the selected product from the table view

        
    
        
          public void loadF() {
    FavorisService ps = new FavorisService();
    List<favoris> lf = ps.ConsulterlistFavoris();
    ObservableList<favoris> dataa = FXCollections.observableArrayList(lf);
    listF.setItems(dataa);
}



    @FXML
    private void supp(ActionEvent event) {
        favoris C = listF.getSelectionModel().getSelectedItem();
    if (C == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerte");
        alert.setHeaderText("Alerte");
        alert.setContentText("Veuillez Choisir un produit dufavoris à supprimer");
        alert.show();
    } else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText(null);
        alert.setContentText("vous êtes sûr de supprimer le produit?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            FavorisService cs= new FavorisService();
            cs.supprimerf(C);
            JOptionPane.showMessageDialog(null, "Produit supprimé du favoris");
            loadF();
        }
    }
    }

   

    }    


   

    

   
    
