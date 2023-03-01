/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author brahmi
 */
public interface InterfaceCRUD {
        public void ajouterFacture();
        public void modifierFacture(Facture f);
        public void supprimerFacture(int id) ;
        public ObservableList<Facture> afficherFacture();
}
