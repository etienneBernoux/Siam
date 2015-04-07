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
    
    public Plateau(Case[][] casePlateau,Case[] caseRhino,Case[] caseElephant){
        this.casePlateau=casePlateau;
        this.caseRhino=caseRhino;
        this.caseElephant=caseElephant;
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
