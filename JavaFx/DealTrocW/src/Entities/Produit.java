/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class Produit {
     private int IdProduit ;
private ImageView image;
private String url; 
private String description;
private String titre;
private String categorie;
private int prix;
private int likes;

    public Produit(int IdProduit, ImageView image, String url, String description, String titre, String categorie, int prix, int likes) {
        this.IdProduit = IdProduit;
        this.image = image;
        this.url = url;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
        this.likes = likes;
    }

    public Produit(int idProduit, String url, String description, String titre, String categorie, int prix, int likes) {
          this.IdProduit = IdProduit;
        this.url = url;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
        this.likes = likes;
        
        ; //To change body of generated methods, choose Tools | Templates.
    }


    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Produit(String url, String description, String titre, String categorie, int prix) {
        this.url = url;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
    }

    public Produit(int IdProduit, String url, String description, String titre, String categorie, int prix) {
        this.IdProduit = IdProduit;
        this.url = url;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
    }
    


    public Produit() {
    }

    public Produit(int IdProduit, ImageView image, String description, String titre, String categorie, int prix) {
        this.IdProduit = IdProduit;
        this.image = image;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
        
    }

    public Produit(ImageView image, String description, String titre, String categorie, int prix) {
        this.image = image;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
    }

    public Produit(int IdProduit, String description, String titre, String categorie, int prix) {
        this.IdProduit = IdProduit;
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
    }
    

    public Produit(String description, String titre, String categorie, int prix) {
        this.description = description;
        this.titre = titre;
        this.categorie = categorie;
        this.prix = prix;
    }
    

    public int getIdProduit() {
        return IdProduit;
    }

    public ImageView getImage() {
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

    public int getPrix() {
        return prix;
    }

    public void setIdProduit(int IdProduit) {
        this.IdProduit = IdProduit;
    }

    public void setImage(ImageView image) {
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

    public void setPrix(int prix) {
        this.prix = prix;
    }




}

