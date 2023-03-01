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
public class Facture {

    private int id_facture, id_produit, id_type_facture;
    private Date date_facture;
    private String description, nom, type_facture;

    public Facture() {
    }

    public Facture(int id_facture, String nom, int id_type_facture, Date date_facture, int id_produit, String description) {

        this.id_facture = id_facture;
        this.nom = nom;
        this.id_type_facture = id_type_facture;
        this.date_facture = date_facture;
        this.id_produit = id_produit;
        this.description = description;
    }

    public Facture(int id_produit
    ) {

        this.id_produit = id_produit;

    }

    public int getId_facture() {
        return id_facture;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_type_facture() {
        return id_type_facture;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public String getType_facture() {
        return type_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_type_facture(int id_type_facture) {
        this.id_type_facture = id_type_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType_facture(String type_facture) {
        this.type_facture = type_facture;
    }

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", type_facture=" + type_facture + ", id_produit=" + id_produit + ", date_facture=" + date_facture + ", description=" + description + ", nom=" + nom + '}';
    }

}
