/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entités.Echange_Achat;
import java.util.List;


/**
 *
 * @author Lenovo
 */
public interface Interface_Echange_Achat {
    public void AjouterEA (Echange_Achat EA);
    public void ModifierEA (Echange_Achat EA);
    public void SupprimerEA (Echange_Achat EA);
    public List<Echange_Achat> ConsulterEA();
    
}
