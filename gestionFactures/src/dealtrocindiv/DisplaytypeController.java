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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brahmi
 */
public class DisplaytypeController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private ImageView update;
    @FXML
    private ImageView delete;
    @FXML
    private TableView<Type_facture> tableTypes;
    @FXML
    private TableColumn<Type_facture, Integer> id;
    @FXML
    private TableColumn<Type_facture, String> nom;
    @FXML
    private TableColumn<Type_facture, String> des;

    /**
     * Initializes the controller class.
     */
    ObservableList<Type_facture> data = FXCollections.observableArrayList();
    @FXML
    private ImageView meloul;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshTable();
    }

    @FXML
    private void update(MouseEvent event) throws IOException {

        Type_facture facture =tableTypes.getSelectionModel().getSelectedItem();
        if (facture != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier.fxml"));
            Parent root = loader.load();
            ModifierController ModifierController = loader.getController();
            ModifierController.initializeData(facture.getId_type_facture());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de selectionner un type !");
            // alert.initOwner(o);
            alert.show();

        }
    }

    @FXML
    private void delete(MouseEvent event) throws IOException {
        if (tableTypes.getSelectionModel().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error form");
            alert.setContentText("Merci de selectionner un type !");
            // alert.initOwner(o);
            alert.show();
        } else {
            int id = tableTypes.getSelectionModel().getSelectedItem().getId_type_facture();
            System.out.println(id);

            //Window o = delete.getScene().getWindow();
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Confirmation");
            alert2.setContentText("Voulez vous suuprimer ce type !");
            //  alert2.initOwner(o);
            alert2.show();
            Type_factureCRUD pc = new Type_factureCRUD();
            pc.supprimerType(id);
        }

//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("error form");
//            alert.setContentText("Merci de selectionner une facture !");
//            // alert.initOwner(o);
//            alert.show();
    }

    private void refreshTable() {
        data.clear();

        Connection conn = MyConnection.getInstance().getConn();
        try {
            String req = "Select * from type_facture ";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {

                data.add(new Type_facture(RS.getInt(1), RS.getString(2), RS.getString(3)));
            }
            System.out.println("pad de problème d'affichage");
            id.setCellValueFactory(new PropertyValueFactory<Type_facture, Integer>("id_type_facture"));
            nom.setCellValueFactory(new PropertyValueFactory<Type_facture, String>("nom"));
            des.setCellValueFactory(new PropertyValueFactory<Type_facture, String>("description"));

            tableTypes.setItems(data);
        } catch (Exception ex) {
            System.out.println("erreur tableview");
            ex.printStackTrace();

        }
    }

    @FXML
    private void actualiser2(MouseEvent event) {
        
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displaytype.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) meloul.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
