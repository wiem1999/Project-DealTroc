/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

/**
 *
 * @author khiar
 */
public class utilisateur { 
    protected int Id_utilisateur ; 
    protected String nom ; 
    protected String prenom ; 
    protected String numero ; 
    protected String Adresse; 
    protected String motDePasse; 
    protected String AdresseEmail ; 
    protected String Image ; 
    protected String Type ; 
    protected int nombreProduitAchetes ;  
    protected int nombreProduitPublier ; 
    protected int nombreProduitVendus ; 
    protected int avis ; 
    protected String role ;

    public utilisateur(int Id_utilisateur, String nom, String prenom, String numero, String Adresse, String motDePasse, String AdresseEmail, String Image, String Type, int nombreProduitAchetes, int nombreProduitPublier, int nombreProduitVendus, int avis, String role) {
        this.Id_utilisateur = Id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.Adresse = Adresse;
        this.motDePasse = motDePasse;
        this.AdresseEmail = AdresseEmail;
        this.Image = Image;
        this.Type = Type;
        this.nombreProduitAchetes = nombreProduitAchetes;
        this.nombreProduitPublier = nombreProduitPublier;
        this.nombreProduitVendus = nombreProduitVendus;
        this.avis = avis;
        this.role = role;
    }

    public utilisateur() {
    }

    public int getId_utilisateur() {
        return Id_utilisateur;
    }

    public void setId_utilisateur(int Id_utilisateur) {
        this.Id_utilisateur = Id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAdresseEmail() {
        return AdresseEmail;
    }

    public void setAdresseEmail(String AdresseEmail) {
        this.AdresseEmail = AdresseEmail;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getNombreProduitAchetes() {
        return nombreProduitAchetes;
    }

    public void setNombreProduitAchetes(int nombreProduitAchetes) {
        this.nombreProduitAchetes = nombreProduitAchetes;
    }

    public int getNombreProduitPublier() {
        return nombreProduitPublier;
    }

    public void setNombreProduitPublier(int nombreProduitPublier) {
        this.nombreProduitPublier = nombreProduitPublier;
    }

    public int getNombreProduitVendus() {
        return nombreProduitVendus;
    }

    public void setNombreProduitVendus(int nombreProduitVendus) {
        this.nombreProduitVendus = nombreProduitVendus;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

 

    @Override
    public String toString() {
        return "utilisateur{" + "Id_utilisateur=" + Id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", Adresse=" + Adresse + ", motDePasse=" + motDePasse + ", AdresseEmail=" + AdresseEmail + ", Image=" + Image + ", Type=" + Type + ", nombreProduitAchetes=" + nombreProduitAchetes + ", nombreProduitPublier=" + nombreProduitPublier + ", nombreProduitVendus=" + nombreProduitVendus + ", avis=" + avis + ", role=" + role + '}';
    }
    
    
    
    
    


    
}
