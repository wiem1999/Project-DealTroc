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
public class favoris {
      private int FIdProduit ;
private ImageView Fimage;
private String Furl; 
private String Fdescription;
private String Ftitre;
private String Fcategorie;
private int Fprix;
private int Flikes ;

    public favoris(int FIdProduit, ImageView Fimage, String Furl, String Fdescription, String Ftitre, String Fcategorie, int Fprix, int Flikes) {
        this.FIdProduit = FIdProduit;
        this.Fimage = Fimage;
        this.Furl = Furl;
        this.Fdescription = Fdescription;
        this.Ftitre = Ftitre;
        this.Fcategorie = Fcategorie;
        this.Fprix = Fprix;
        this.Flikes = Flikes;
    }

    public favoris(int FIdProduit, ImageView Fimage, String Furl, String Fdescription, String Ftitre, String Fcategorie, int Fprix) {
        this.FIdProduit = FIdProduit;
        this.Fimage = Fimage;
        this.Furl = Furl;
        this.Fdescription = Fdescription;
        this.Ftitre = Ftitre;
        this.Fcategorie = Fcategorie;
        this.Fprix = Fprix;
    }

    public favoris() {
    }

    public void setFIdProduit(int FIdProduit) {
        this.FIdProduit = FIdProduit;
    }

    public void setFimage(ImageView Fimage) {
        this.Fimage = Fimage;
    }

    public void setFurl(String Furl) {
        this.Furl = Furl;
    }

    public void setFdescription(String Fdescription) {
        this.Fdescription = Fdescription;
    }

    public void setFtitre(String Ftitre) {
        this.Ftitre = Ftitre;
    }

    public void setFcategorie(String Fcategorie) {
        this.Fcategorie = Fcategorie;
    }

    public void setFprix(int Fprix) {
        this.Fprix = Fprix;
    }

    public void setFlikes(int Flikes) {
        this.Flikes = Flikes;
    }

    public int getFIdProduit() {
        return FIdProduit;
    }

    public ImageView getFimage() {
        return Fimage;
    }

    public String getFurl() {
        return Furl;
    }

    public String getFdescription() {
        return Fdescription;
    }

    public String getFtitre() {
        return Ftitre;
    }

    public String getFcategorie() {
        return Fcategorie;
    }

    public int getFprix() {
        return Fprix;
    }

    public int getFlikes() {
        return Flikes;
    }




}

