/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;

import Entities.Produit;
import Services.ProduitService;
import Util.MyConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DisplayProductsController implements Initializable {

    @FXML
    private TextField searchbar;
    @FXML
    private TableView<Produit> tabProduit;
    @FXML
    private TableColumn<Produit, Integer> idcell;
    @FXML
    private TableColumn<Produit, String> titrecell;
    @FXML
    private TableColumn<Produit, String> desccell;
    @FXML
    private TableColumn<Produit, String> catcell;
    @FXML
    private TableColumn<Produit, Integer> prixcell;
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
    private Button fav;
    @FXML
    private Label labelLikes;
    /**
     * Initializes the controller class.
     */
    ProduitService ps = new ProduitService();
    @FXML
    private ImageView image_up;
    @FXML
    private Button bf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Produit> la = ps.ConsulterlistProduit();
        ObservableList<Produit> data= FXCollections.observableArrayList(la);

        idcell.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        titrecell.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desccell.setCellValueFactory(new PropertyValueFactory<>("Description"));
        catcell.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        prixcell.setCellValueFactory(new PropertyValueFactory<>("Prix"));

        tabProduit.setItems(data);
        
               SortedList<Produit> sortedData=tableViewSearchFilter(data);
   tabProduit.setItems(sortedData);
       
       
        tabProduit.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            // Update the labels and image view with the selected item's details
            Lt.setText(newSelection.getTitre());
            Ld.setText(newSelection.getDescription());
            Lc.setText(newSelection.getCategorie());
            Lp.setText(String.valueOf(newSelection.getPrix()));
            File file = new File(newSelection.getUrl());
            Image image = new Image(file.toURI().toString());
            image_up.setImage(image);
            labelLikes.setText(String.valueOf(newSelection.getLikes()));
            
            
        }
 
    });
    //     Produit produit = tabProduit.getSelectionModel().getSelectedItem();
    // set the initial number of likes for the selected product
    
  //  like = produit.getLikes();
    // display the number of likes in the UI
  //  labelLikes.setText(Integer.toString(like)); 
        
    }    

  

    @FXML
private void addToFavoris(ActionEvent event) {
    MyConnection instance = MyConnection.getInstance(); 
    Connection cnx;
    Produit selectedProduit = tabProduit.getSelectionModel().getSelectedItem();
     
    if (selectedProduit != null) {
        Produit favori = new Produit(0, selectedProduit.getUrl(), selectedProduit.getDescription(),
                selectedProduit.getTitre(), selectedProduit.getCategorie(), selectedProduit.getPrix(), selectedProduit.getLikes());
        String insertFavoriSql = "INSERT INTO favoris (url, description, titre, categorie, prix ) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getConn().prepareStatement(insertFavoriSql);
            pst.setString(1, favori.getUrl());
            pst.setString(2, favori.getDescription());
            pst.setString(3, favori.getTitre());
            pst.setString(4, favori.getCategorie());
            pst.setInt(5, favori.getPrix());
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setHeaderText(null);
alert.setContentText("Produit ajouté aux favoris");
alert.showAndWait();        } catch (SQLException ex) {
            Logger.getLogger(DisplayProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Increment the likes of the selected product
        int likes = selectedProduit.getLikes() + 1;
        selectedProduit.setLikes(likes);
        ps.updateLikes(selectedProduit.getIdProduit(), likes);
        
        // Update the UI to reflect the new number of likes
        labelLikes.setText(Integer.toString(likes));
    
}}

public SortedList<Produit> tableViewSearchFilter(ObservableList<Produit> olist) {
                FilteredList<Produit> filteredData = new FilteredList<>(olist, b -> true);
 
    searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
         
                filteredData.setPredicate(art -> {
                    // If filter text is empty, display all persons.
                    
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();
                    
                    if (art.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1||
                            art.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ||
                            
                            art.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1||
                            art.getUrl().toLowerCase().indexOf(lowerCaseFilter) != -1||
                            art.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1||
                            Integer.toString(art.getPrix()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches first name.
                    } else
                        return false; // Does not match.
                });
            });
            // 3. Wrap the FilteredList in a SortedList.
            SortedList<Produit> sortedData = new SortedList<>(filteredData);
            // 4. Bind the SortedList comparator to the TableView comparator.
            // 	  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(tabProduit.comparatorProperty());
                 // 5. Add sorted (and filtered) data to the table. 
                 return sortedData;
    }

    @FXML
   private void DispFav(ActionEvent event) throws IOException {
    // Load the Favoris.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FavorisFXML.fxml"));
        Parent root = loader.load();
    
    // Get the controller for the Favoris.fxml file
        FavorisFXMLController favorisController = loader.getController();
    
    // Display the loaded FXML file
        Scene scene = new Scene(root);
        Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
   }



    @FXML
    private void ProductsOfTheDay(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayPromos.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
    }
    



  

   
}

    

  
    
    

