/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Promo {
   private int idPromo;
   private String titre;
   private String description ;
   private int pourcentage;
   private Float prix ;
   private Date date_deb;
   private Date date_fin;
   private int promoPrix;

    public Promo(String titre, String description, int pourcentage, Float prix, Date date_deb, Date date_fin, int promoPrix) {
        this.titre = titre;
        this.description = description;
        this.pourcentage = pourcentage;
        this.prix = prix;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.promoPrix = promoPrix;
    }
   
   

    public Promo(String titre, String description, int pourcentage, Float prix, Date date_deb, Date date_fin) {
        this.titre = titre;
        this.description = description;
        this.pourcentage = pourcentage;
        this.prix = prix;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    }

    public void setDate_deb(Date date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setPromoPrix(int promoPrix) {
        this.promoPrix = promoPrix;
    }

    public Date getDate_deb() {
        return date_deb;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getPromoPrix() {
        return promoPrix;
    }
   
   
   

    public Promo(int idPromo, String titre, String description, int pourcentage, Float prix) {
        this.idPromo = idPromo;
        this.titre = titre;
        this.description = description;
        this.pourcentage = pourcentage;
        this.prix = prix;
    }

    public Promo(String titre, String description, Float prix, Date date_deb, Date date_fin) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    }

    public Promo() {
    }

    public Promo(String titre, String description, int pourcentage, Float prix) {
        this.titre = titre;
        this.description = description;
        this.pourcentage = pourcentage;
        this.prix = prix;
    }

   
   
   
   
    public void setIdPromo(int idPromo) {
        this.idPromo = idPromo;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

   
   
    public int getIdPromo() {
        return idPromo;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public Float getPrix() {
        return prix;
    }
   
   
   
   
   
   
}


