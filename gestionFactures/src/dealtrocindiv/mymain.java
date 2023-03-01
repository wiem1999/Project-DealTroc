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
public class mymain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FactureCRUD c = new FactureCRUD();

        System.out.println(c.afficherFactureUne("2"));
        // crud.ajouterFacture3("20");
//        crud.afficherFacture();
//        System.out.println(crud.afficherFacture());
//        crud.supprimerFacture(10);
        Type_facture t = new Type_facture(0, "commercial", "ddddd");
        Type_factureCRUD c2 = new Type_factureCRUD();

        c2.Ajouter(t);

    }

}
