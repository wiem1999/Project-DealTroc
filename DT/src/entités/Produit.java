/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Produit {
    
    public int id_produit ;
    public String image;
    public String description ;
    public String titre ;
    public String categorie ;

    public Produit(int id_produit, String image, String description, String titre, String categorie) {
        this.id_produit = id_produit;
        this.image = image;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
    }

    public Produit(int id_produit, String titre, String categorie) {
        this.id_produit = id_produit;
        this.titre = titre;
        this.categorie = categorie;
    }

    public int getId_produit() {
        return id_produit;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Produit other = (Produit) obj;
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", image=" + image + ", description=" + description + ", titre=" + titre + ", categorie=" + categorie + '}';
    }
    
    
    
    
    
    
    
}
