/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author cyril_000
 */
public class PionJoueur extends Piece{

    private int direction; 
    
    public PionJoueur() {
        super(1);
        direction=0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;         
        /*on doit mettre un rapport entre les direcitons et les chiffres
        je propose 0=bas 1=droite 2=haut 3=gauche*/ 
        
    }
    
}
