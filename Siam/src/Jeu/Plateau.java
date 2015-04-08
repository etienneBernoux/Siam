/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

/**
 *
 * @author Etienne
 */
public class Plateau {

    private Case[][] casePlateau;
    private Case[] caseRhino;
    private Case[] caseElephant;

    public Plateau(int x, int y, int nbRhyno, int nbEleph) {
        for (int i=0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i!=0 && i!=x-1 && j==(y/2)){
                this.casePlateau[i][j] = new Case(i,j,3);
                System.out.println("Creation d'une montagne en "+i +"-"+j);
                }
                else{
                this.casePlateau[i][j] = new Case(i,j,4);
                System.out.println("Creation d'une case vide en "+i +"-"+j);
                }
                
            }
        }
        for (int i=0; nbRhyno < x; i++) {
        this.caseRhino[i] = new Case(i,0,0);
        System.out.println("Creation du "+i +"eme Rhyno");
        }
        for (int i=0; nbEleph < x; i++) {
        this.caseElephant[i] = new Case(i,0,1);
        System.out.println("Creation du "+i +"eme Eleph");
        }
        
    }

    /**
     * @return the casePlateau
     */
    public Case[][] getCasePlateau() {
        return casePlateau;
    }

    /**
     * @return the caseRhino
     */
    public Case[] getCaseRhino() {
        return caseRhino;
    }

    /**
     * @return the caseElephant
     */
    public Case[] getCaseElephant() {
        return caseElephant;
    }
}
