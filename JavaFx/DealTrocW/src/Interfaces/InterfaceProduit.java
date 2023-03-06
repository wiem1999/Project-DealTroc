/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import Entities.Produit;

/**
 *
 * @author ASUS
 */
public interface InterfaceProduit {

    /**
     *
     * @param p
     */
    void AjouterProduit (Produit p);
    void ConsulterProduit(); 
    public List<Produit> ConsulterlistProduit();
    void ModifierProduit(Produit p); 
    void supprimer (Produit p);
    public List<Produit> RandomSelectProduct(int n);
   
}
