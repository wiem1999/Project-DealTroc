/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;

import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author brahmi
 */
public class FactureWindow1Controller implements Initializable {

    @FXML
    private AnchorPane nombreProduit;
    @FXML
    private Button actualiser;
    @FXML
    private ImageView search;
    @FXML
    private TextField chercher;
    @FXML
    private ImageView notification;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView imageUser;
    @FXML
    private Label NomUser;
    @FXML
    private ImageView position;
    @FXML
    private Label Adresse;
    @FXML
    private Label Numero;
    @FXML
    private TableView<Facture> factures;
    @FXML
    private TableColumn<Facture, Integer> id_facture;
    @FXML
    private TableColumn<Facture, String> nom;
    @FXML
    private TableColumn<Facture, Integer> id_type_facture;
    @FXML
    private TableColumn<Facture, String> date_facture;
    @FXML
    private TableColumn<Facture, Integer> id_produit;
    @FXML
    private TableColumn<Facture, String> description;

    // Facture facture = null;
    ObservableList<Facture> data1 = FXCollections.observableArrayList();
    @FXML
    private ImageView add;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView update;
    @FXML
    private PieChart pieChart;

    Statement ste, ste2;
    Connection conx = MyConnection.getInstance().getConn();
    @FXML
    private ImageView meloul;
    @FXML
    private ImageView display;
    @FXML
    private Button addtype;
    @FXML
    private ImageView mail1;
    @FXML
    private AnchorPane facturesS;
    @FXML
    private Label nbfactures;
    @FXML
    private AnchorPane type;
    @FXML
    private Label nbtype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTable();
      count1();
      count2();

        try {
            ste = conx.createStatement();
            ste2 = conx.createStatement();
            ResultSet rs = ste.executeQuery("SELECT * FROM type_facture");

            while (rs.next()) {
                ResultSet rs2 = ste2.executeQuery("SELECT COUNT(*) AS total FROM facture WHERE id_type_facture =" + rs.getInt("id_type_facture") + "");
                while (rs2.next()) {

                    ObservableList<PieChart.Data> pieChartData
                            = FXCollections.observableArrayList(
                                    new PieChart.Data(rs.getString("nom"), rs2.getInt("total")));

                    pieChartData.forEach(data
                            -> data.nameProperty().bind(
                                    Bindings.concat(
                                            data.getName(), " :factures enregistrées: ", data.pieValueProperty()
                                    )
                            )
                    );

                    pieChart.getData().addAll(pieChartData);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(FactureWindow1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {

        data1.clear();
        try {
            FactureCRUD crud = new FactureCRUD();
            data1 = crud.afficherFacture();
            id_facture.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id_facture"));
            nom.setCellValueFactory(new PropertyValueFactory<Facture, String>("nom"));
            id_type_facture.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id_type_facture"));
            date_facture.setCellValueFactory(new PropertyValueFactory<Facture, String>("date_facture"));
            id_produit.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id_produit"));
            description.setCellValueFactory(new PropertyValueFactory<Facture, String>("description"));
            factures.setItems(data1);
        } catch (Exception ex) {
            System.out.println("erreur tableview");
            ex.printStackTrace();
        }

    }

    @FXML
    private void actualiser(ActionEvent event) {

        FactureCRUD crud = new FactureCRUD();
        crud.ajouterFacture();
    }

    @FXML
    void getAddView(MouseEvent event) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("commandesNonFacturés.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FactureWindow1Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur liste commandes non facturés");
        }

    }

    @FXML
    private void noir(MouseDragEvent event) {
    }

    @FXML
    private void noir(DragEvent event) {
    }

    @FXML
    private void deleteFacture(MouseEvent event) throws IOException {
        if (factures.getSelectionModel().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de selectionner une facture !");
            // alert.initOwner(o);
            alert.show();
        } else {
            int id = factures.getSelectionModel().getSelectedItem().getId_facture();
            System.out.println(id);

            //Window o = delete.getScene().getWindow();
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Confirmation");
            alert2.setContentText("Voulez vous suuprimer cette facture !");
            //  alert2.initOwner(o);
            alert2.show();
            FactureCRUD c = new FactureCRUD();
            c.supprimerFacture(id);
        }

//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("error form");
//            alert.setContentText("Merci de selectionner une facture !");
//            // alert.initOwner(o);
//            alert.show();
    }

    @FXML
    private void updateFacture(MouseEvent event) throws IOException {

        Facture facture = factures.getSelectionModel().getSelectedItem();
        if (facture != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier.fxml"));
            Parent root = loader.load();
            ModifierController ModifierController = loader.getController();
            ModifierController.initializeData(facture.getId_facture());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de selectionner une facture !");
            // alert.initOwner(o);
            alert.show();

        }
    }

    @FXML
    private void actualiser2(MouseEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FactureWindow1.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) meloul.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnNotifcationOnAction(MouseEvent event) {
        Connection conn = MyConnection.getInstance().getConn();
        try {
            String req = "Select count(*) as total from Commande where id_produit NOT IN (select id_produit from facture)";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                // Image image=new Image("/image/error.png");
                Notifications notifications = Notifications.create();
                //notifications.graphic(new ImageView(image));
                notifications.text("Rania il ya " + RS.getInt("total") + " à ajouter  ");
                notifications.title("Vouvelles commandes !!");
                notifications.hideAfter(Duration.seconds(10));

                // notifications.position(Pos.BOTTOM_CENTER);*/
                notifications.show();

            }

        } catch (Exception ex) {
            System.out.println("erreur tableview");
            ex.printStackTrace();

        }

    }

    @FXML
    private void display(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("displaytype.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FactureWindow1Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur display");
        }
    }

    @FXML
    private void addtype(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addtype.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FactureWindow1Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur display");
        }
    }



    @FXML
    private void mail(MouseEvent event) {
           try {
            Parent parent = FXMLLoader.load(getClass().getResource("testmail.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FactureWindow1Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur");
        }
    }

    private void count1() {
         Connection conn = MyConnection.getInstance().getConn();
        try {
            String req = "Select count(*) as total from facture ";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                // Image image=new Image("/image/error.png");
               
                //notifications.graphic(new ImageView(image));
               nbfactures.setText( RS.getInt("total")+" Factures");
              
               
               

                // notifications.position(Pos.BOTTOM_CENTER);*/
                

            }

        } catch (Exception ex) {
            System.out.println("erreur nbF");
            ex.printStackTrace();

        }
    }

    private void count2() {
          Connection conn = MyConnection.getInstance().getConn();
        try {
            String req = "Select count(*) as total from type_facture ";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                // Image image=new Image("/image/error.png");
               
                //notifications.graphic(new ImageView(image));
               nbtype.setText( RS.getInt("total")+" Types");
              
               
               

                // notifications.position(Pos.BOTTOM_CENTER);*/
                

            }

        } catch (Exception ex) {
            System.out.println("erreur nbT");
            ex.printStackTrace();

        }
    }

}
