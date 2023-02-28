/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocw;
import Api.GenerateQRCode;
import Api.sendSMS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import Entities.Produit;
import Services.ProduitService;
import Util.MyConnection;
import com.google.zxing.WriterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ProdGUIController implements Initializable {
    
    private Label label;
    
     @FXML
     private TableView<Produit> tabProduit;

    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfcat;
    @FXML
    private TextField tfprix;
 

    private ComboBox<Integer> comboid;
    
    
    Produit p = new Produit();
  ProduitService ps = new ProduitService();
    @FXML
    private TextField searchbar;
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
    private Button image;
    public static FileChooser fc = new FileChooser();
    File selectedfile;
    String path;
    @FXML
    private ImageView image_update;
    @FXML
    private Button Ajout;
    @FXML
    private ToggleButton btnUpload;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btnsupp;
    @FXML
    private Button bdisp;

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    public void loadP() {
    ProduitService ps = new ProduitService();
    List<Produit> la = ps.ConsulterlistProduit();
    ObservableList<Produit> data = FXCollections.observableArrayList(la);
    tabProduit.setItems(data);
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        ProduitService ps = new ProduitService();
        
        List<Produit> la = ps.ConsulterlistProduit();
        ObservableList<Produit> data= FXCollections.observableArrayList(la);

        idcell.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        titrecell.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desccell.setCellValueFactory(new PropertyValueFactory<>("Description"));
        catcell.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        prixcell.setCellValueFactory(new PropertyValueFactory<>("Prix"));

        tabProduit.setItems(data);
       
        

    }    


    @FXML
    private void Ajouter(ActionEvent event) {
        {
  
        try {
            //// SAVE ARTICLE IN DB
            String titre = tftitre.getText();
            String desc = tfdesc.getText();
            String cat = tfcat.getText();
            int prix = Integer.parseInt(tfprix.getText());
            if((tftitre.equals(""))||(tfdesc.equals("")) ||(tfcat.equals(""))||(tfprix.equals(""))){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alerte");
                alert.setHeaderText("Alerte");
                alert.setContentText("Veuillez remplir les champs vides");
                alert.show();
            }
            else
            {
                     //    Produit p = new Produit(titre,desc,cat,prixInt);
                Produit p = new Produit(path, desc, titre, cat, prix);

                ProduitService ps = new ProduitService();
                ps.AjouterProduit(p);
                             try {
    sendSMS sm = new sendSMS();
    sm.sendSMS(p);
} catch (Exception e) {
    // handle the exception here
    e.printStackTrace();
}
                

                JOptionPane.showMessageDialog(null, "produit ajouté");
  

String path = "C:/Users/ASUS/Documents/qr/code.png";
try{
            GenerateQRCode.generateQRcode(p, path);
            } catch (WriterException e) {
    e.printStackTrace();
}
                //REDIRECTION
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("ProduitGUI.fxml"));
                Parent root = loader.load();
                tftitre.getScene().setRoot(root);}
                        loadP();
                        
                       

        } catch (IOException ex) {
            Logger.getLogger(ProdGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
         
    
    }
    
    
     @FXML
    private void importerImageUpdate(ActionEvent event) throws MalformedURLException, FileNotFoundException {

        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        //System.out.println(System.getProperty("user.home"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedfile = fc.showOpenDialog(null);
        if (selectedfile != null) {
            
            path = selectedfile.getAbsolutePath();
//                path = selectedFile.toURI().toURL().toExternalForm();
           Image img=new Image(selectedfile.toURI().toString());
//           img_pub=new ImageView(img);
           image_update.setImage(img);
           image_update.setFitHeight(150);
           image_update.setFitWidth(250);
           image.setText(path);

        }
    }


   @FXML
private void btnsupp(ActionEvent event) {
    Produit C = tabProduit.getSelectionModel().getSelectedItem();
    if (C == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerte");
        alert.setHeaderText("Alerte");
        alert.setContentText("Veuillez Choisir un produit à supprimer");
        alert.show();
    } else {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText(null);
        alert.setContentText("vous êtes sûr de supprimer le produit?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            ProduitService cs= new ProduitService();
            cs.supprimer(C);
            JOptionPane.showMessageDialog(null, "Produit supprimé");
            loadP();
        }
    }
}


    private void getId(ActionEvent event) {
        comboid.setOnAction(e ->{
            String req="select * from produit where id=?";
            try {
                    PreparedStatement pst = MyConnection.getInstance().getConn()
                    .prepareStatement(req);             
                    pst.setInt(1,(Integer)comboid.getSelectionModel().getSelectedItem());
                ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    tftitre.setText(rs.getString("titre"));
                    tfdesc.setText(rs.getString("Description"));
                    tfprix.setText(rs.getString("prix"));
                    tfcat.setText(rs.getString("Categorie"));
                    String s= rs.getString("url");
                     File file = new File(s);
Image image = new Image(file.toURI().toString());
image_update.setImage(image);
                 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        tftitre.setText(p.getTitre());
        tfdesc.setText(p.getDescription());
        tfprix.setText(String.valueOf(p.getPrix()));
        tfcat.setText(p.getCategorie());
     
        

    }
    

    @FXML
    private void ModifierProduit(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierGUI.fxml"));
    Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
        
    }
@FXML
    private void dispProd(ActionEvent event) throws IOException {
    // Load the DisplayProducts.fxml file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayProducts.fxml"));
    Parent root = loader.load();
    
    // Get the stage information
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    
    // Set the new scene
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}
             
    }

    
    
    
    
    
    

    

