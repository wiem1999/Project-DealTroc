/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;

import Entities.Produit;
import Services.ProduitService;
import Util.MyConnection;
import static dealtrocw.ProdGUIController.fc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierGUIController implements Initializable {

    @FXML
    private TextField searchbar;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfcat;
    @FXML
    private TextField tfprix;
    @FXML
    private ImageView image_up;
    @FXML
    private Button btnmodif;
    @FXML
    private ComboBox<Integer> comboid;
    
        public static FileChooser fc = new FileChooser();
    File selectedfile;
    String path;


    ProduitService ps = new ProduitService();
    Produit p= new Produit();
    @FXML
    private Button btb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // TODO
            String req="select IdProduit from produit";
            PreparedStatement pst = MyConnection.getInstance().getConn()
                    .prepareStatement(req);
            ResultSet rs=pst.executeQuery();
            ObservableList<Integer> id = null;
            List<Integer> list = new ArrayList<>();
            while(rs.next()){
             
             list.add(rs.getInt("IdProduit"));
            
            }
            id = FXCollections
                    .observableArrayList(list);
            comboid.setItems(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModifierGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void ModifierProduit(ActionEvent event) {
        
      //Integer prix= Integer.parseInt(tfprix.getText());
      try{
          ps.ModifierProduit(new Produit(comboid.getSelectionModel().getSelectedItem(),
                  tftitre.getText(),
                  tfdesc.getText(),
                  tfcat.getText(),
                  Integer.parseInt(tfprix.getText())));       
        JOptionPane.showMessageDialog(null, "Produit modifié");
         } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Le prix doit être un nombre entier");
    }
       
        
        
    }

    @FXML
    private void getId(MouseEvent event) {
        comboid.setOnAction(e ->{
            String req="select titre,Description ,Categorie ,prix from produit where IdProduit=?";
            try {
                    PreparedStatement pst = MyConnection.getInstance().getConn()
                    .prepareStatement(req);             
                    pst.setInt(1,(Integer)comboid.getSelectionModel().getSelectedItem());
                ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    tftitre.setText(rs.getString("titre"));
                    tfdesc.setText(rs.getString("Description"));
                    tfcat.setText(rs.getString("Categorie"));
                    tfprix.setText(rs.getString("prix"));

                 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModifierGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        tftitre.setText(p.getTitre());
        tfdesc.setText(p.getDescription());
        tfcat.setText(p.getCategorie());
        tfprix.setText(String.valueOf(p.getPrix()));

        
    }

    @FXML
    private void back(ActionEvent event)throws IOException{
        // Load the Favoris.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProdGUI.fxml"));
        Parent root = loader.load();
    
    // Get the controller for the Favoris.fxml file
        ProdGUIController ProdController = loader.getController();
    
    // Display the loaded FXML file
        Scene scene = new Scene(root);
        Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
    }
    

}
