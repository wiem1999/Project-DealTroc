/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Echange_Achat {
    
     public String role ;
    private int id_operation;
    private int id_utilisateur ;
    private int idRDV;
    private double prix ; 
    private String rating ;
    public ArrayList Echange_Achat = new ArrayList<>();
    

    public Echange_Achat (String role ,int id_operation , int id_utilisateur  ,int idRDV, double prix , String rating) {
        this.role=role;
        this.id_operation= id_operation;
        this.id_utilisateur= id_utilisateur;
        this.idRDV=idRDV;
        this.prix= prix;
        this.rating=rating ;
   
        
    }

    public int getId_operation() {
        return id_operation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
    
       public int getIdRDV() {
        return idRDV;
    }
    

    public double getPrix() {
        return prix;
    }

    public String getRating() {
        return rating;
    }

 
    public void setId_operation(int id_operation) {
        this.id_operation = id_operation;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
    }
       

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

  


    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Echange_Achat other = (Echange_Achat) obj;
        if (this.id_operation != other.id_operation) {
            return false;
        }
        if (this.id_utilisateur != other.id_utilisateur) {
            return false;
        }
        if (this.idRDV != other.idRDV) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Echange_Achat{" + "role=" + role + ", id_operation=" + id_operation + ", id_utilisateur=" + id_utilisateur + ", idRDV=" + idRDV + ", prix=" + prix + ", rating=" + rating + '}';
    }
    
    

    
    
}
