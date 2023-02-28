/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.favoris;

/**
 *
 * @author ASUS
 */
public interface InterfaceFavoris {
    
    public void supprimerf(favoris p);
    public void updateLikes(int productId, int likes);
}
