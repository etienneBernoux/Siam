/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import java.awt.Image;

/**
 *
 * @author cyril_000
 */
public class Piece {
    private final double poid;
    Image image;// à voir comment on fait et la sécu
    
    Piece (float poid){
        this.poid=poid;
    }
    double getPoid(){
        return this.poid;
    }
    
}
