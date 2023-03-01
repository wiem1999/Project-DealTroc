/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

import java.util.Date;

/**
 *
 * @author brahmi
 */
public class Commande {

    private int id_commande, id_utilisateur, id_produit, role, status;
    private Date date;

    public Commande() {
    }

    public Commande(int id_commande, int id_utilisateur, int id_produit, Date date, int role, int status) {
        this.id_commande = id_commande;
        this.id_utilisateur = id_utilisateur;
        this.id_produit = id_produit;
        this.date = date;
        this.role = role;
        this.status = status;

    }

    public int getId_commande() {
        return id_commande;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getRole() {
        return role;
    }

    public int getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", id_utilisateur=" + id_utilisateur + ", id_produit=" + id_produit + ", role=" + role + ", status=" + status + ", date=" + date + '}';
    }
    
    
    
    
}
