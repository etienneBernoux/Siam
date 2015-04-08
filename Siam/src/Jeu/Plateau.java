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
        casePlateau=new Case [x][y];
        caseRhino=new Case [nbRhyno];
        caseElephant=new Case [nbEleph];
        for (int i=0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i!=0 && i!=x-1 && j==(y/2)){
                this.casePlateau[i][j] = new Case(i,j,2);
                System.out.println("Creation d'une montagne en "+i +"-"+j);
                }
                else{
                this.casePlateau[i][j] = new Case(i,j,3);
                System.out.println("Creation d'une case vide en "+i +"-"+j);
                }
                
            }
        }
        for (int i=0; nbRhyno > i; i++) {
        this.caseRhino[i] = new Case(i,0,0);
        System.out.println("Creation du "+i +"eme Rhyno");
        }
        for (int i=0; nbEleph > i; i++) {
        this.caseElephant[i] = new Case(i,0,1);
        System.out.println("Creation du "+i +"eme Eleph");
        }
        
    }
    
    /**
     * entre pion,on entre un pion sur le terrain
     * @param x
     * @param y
     * @param type
     * @param plateau
     * @return 
     */
    public int testCase(int x,int y,int type,Plateau plateau){
        int val=0;
        switch (type){
            case 0: val= plateau.caseRhino[x].getTypeContenue();
                break;
            case 1: val= plateau.caseElephant[x].getTypeContenue();
                break;
            case 2: val= plateau.casePlateau[x][y].getTypeContenue();
                break;
        }
        return val;
    }
    public boolean testEntreePion(int x,int y,int noPion,Plateau plateau,int joueur){
        boolean test;
        if (joueur==0 &&  )
    }
    public void entreePion(int x,int y,int noPion,Plateau plateau,int direction){
        
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
