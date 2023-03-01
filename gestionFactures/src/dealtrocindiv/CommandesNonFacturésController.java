/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author brahmi
 */
public class CommandesNonFacturésController implements Initializable {

    @FXML
    private TableView<Commande> tableCommandes;
    @FXML
    private TableColumn<Commande, Integer> id_commande;
    @FXML
    private TableColumn<Commande, Integer> id_utilisateur;
    @FXML
    private TableColumn<Commande, Integer> id_produit;
    @FXML
    private TableColumn<Commande, String> date;
    @FXML
    private TableColumn<Commande, Integer> role;
    @FXML
    private TableColumn<Commande, Integer> status;

    /**
     * Initializes the controller class.
     */
    ObservableList<Commande> data = FXCollections.observableArrayList();
    @FXML
    Button bouttonplus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTable();

    }

    private void refreshTable() {
        data.clear();

        Connection conn = MyConnection.getInstance().getConn();
        try {
            String req = "Select * from Commande where id_produit NOT IN (select id_produit from facture)";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {

                data.add(new Commande(RS.getInt(1), RS.getInt(2), RS.getInt(3), RS.getDate(4), RS.getInt(5), RS.getInt(6)));
            }
            System.out.println("pad de problème d'affichage");
            id_commande.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_commande"));
            id_utilisateur.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_utilisateur"));
            id_produit.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id_produit"));
            date.setCellValueFactory(new PropertyValueFactory<Commande, String>("date"));
            role.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("role"));
            status.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("status"));
            tableCommandes.setItems(data);
        } catch (Exception ex) {
            System.out.println("erreur tableview");
            ex.printStackTrace();

        }
    }

    @FXML
    void Gotoadd(ActionEvent event) throws IOException {

        Commande commande = tableCommandes.getSelectionModel().getSelectedItem();
        if (commande != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/dealtrocindiv/addFacture.fxml"));

            System.out.println("-----------tawa error ---------------");
            Parent root = loader.load();
            AddFactureController AddFactureController = loader.getController();
            AddFactureController.initializeData(commande.getId_produit());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }

}
