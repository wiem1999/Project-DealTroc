/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.Commande;
import javafx.collections.ObservableList;


/**
 *
 * @author Lenovo
 */
public interface Interface_Commande {
    public void AjouterC (Commande C);
    public void AjouterC2 (Commande C);
    public void ModifierC (Commande C);
    public void SupprimerC (Commande C);
    public ObservableList<Commande> AfficherC();
  
}
