/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;


import java.sql.Date;
import java.time.LocalDate;


/**
 *
 * @author Lenovo
 */
public class Commande {
    
      private int id_commande;
    private int id_utilisateur;
    private int id_produit;
    public LocalDate date;
    private String role;
    private String status;

    public Commande() {
    }

    public Commande(int id_commande, int id_utilisateur, int id_produit, LocalDate date, String role, String status) {
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

    public LocalDate getDate() {
        return date;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setId_produit(int id_produuit) {
        this.id_produit = id_produuit;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", id_utilisateur=" + id_utilisateur + ", id_produit=" + id_produit + ", date=" + date + ", role=" + role + ", status=" + status + '}';
    }

   
}
