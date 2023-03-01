/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealtrocindiv;

/**
 *
 * @author brahmi
 */
public class Type_facture {
    
    private int id_type_facture ;
    private String nom ;
    private String description ;
    
    public Type_facture (){}

    
    public Type_facture(int id ,String n,String des){
    
    id_type_facture=id;
    nom=n;
    description=des;
    }
    
    public int getId_type_facture() {
        return id_type_facture;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId_type_facture(int id_type_facture) {
        this.id_type_facture = id_type_facture;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Type_facture{" + "id_type_facture=" + id_type_facture + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
    
    
    
    
}
