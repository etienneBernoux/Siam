/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import static Jeu.Case.ELEPHANT;
import static Jeu.Case.MONTAGNE;
import static Jeu.Case.RHYNOCEROS;
import static Jeu.Case.VIDE;
import static Jeu.PionJoueur.BAS;
import static Jeu.PionJoueur.DROITE;
import static Jeu.PionJoueur.GAUCHE;
import static Jeu.PionJoueur.HAUT;

/**
 *
 * @author Etienne
 */
public class Plateau {

    private Case[][] casePlateau;
    private Case[] caseRhino;
    private Case[] caseElephant;
    private int longueur;
    private int hauteur;
    private int nbRhyno;
    private int nbEleph;

    public Plateau(int x, int y, int nbRhyno, int nbEleph) {
        this.longueur = x;
        this.hauteur = y;
        this.nbRhyno = nbRhyno;
        this.nbEleph = nbEleph;
        this.casePlateau = new Case[x][y];
        this.caseRhino = new Case[nbRhyno];
        this.caseElephant = new Case[nbEleph];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i != 0 && i != x - 1 && j == (y / 2)) {
                    this.casePlateau[i][j] = new Case(i, j, 2);
                    System.out.println("Creation d'une montagne en " + i + "-" + j);
                } else {
                    this.casePlateau[i][j] = new Case(i, j, 3);
                    System.out.println("Creation d'une case vide en " + i + "-" + j);
                }
            }
        }
        for (int i = 0; nbRhyno > i; i++) {
            this.caseRhino[i] = new Case(i, 0, 0);
            System.out.println("Creation du " + i + "eme Rhyno");
        }
        for (int i = 0; nbEleph > i; i++) {
            this.caseElephant[i] = new Case(i, 0, 1);
            System.out.println("Creation du " + i + "eme Eleph");
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

    /**
     * @return the longueur
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * @return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @return the nbRhyno
     */
    public int getNbRhyno() {
        return nbRhyno;
    }

    /**
     * @return the nbEleph
     */
    public int getNbEleph() {
        return nbEleph;
    }

    /**
     * entre pion,on entre un pion sur le terrain
     *
     * @param x
     * @param y
     * @param type
     * @param plateau
     * @return val ou -1 si case impossible
     */
    public int testCasePlateau(int x, int y, int type, Plateau plateau) {
        int val = 0;
        switch (type) {
            case 0:
                if (plateau.getNbRhyno() <= x || x <= 0) {
                    return (-1);
                }
                val = plateau.caseRhino[x].getTypeContenue();
                break;
            case 1:
                if (plateau.getNbEleph() <= x || x <= 0) {
                    return (-1);
                }
                val = plateau.caseElephant[x].getTypeContenue();
                break;
            case 2:
                if ((plateau.getHauteur() <= x || x <= 0) && (plateau.getLongueur() <= y || y <= -1)) {
                    return (-1);
                }
                val = plateau.casePlateau[x][y].getTypeContenue();
                break;
        }
        return val;
    }

    public int modifX(int x, int direction) {
        switch (direction) {
            case DROITE:
                x++;
                break;
            case GAUCHE:
                x--;
                break;
        }
        return x;
    }

    public int modifY(int y, int direction) {
        switch (direction) {
            case HAUT:
                y++;
                break;
            case BAS:
                y--;
                break;
        }
        return y;
    }

    public int invJoueur(int joueur) {
        if (joueur == RHYNOCEROS) {
            return ELEPHANT;
        }
        return RHYNOCEROS;
    }

    public float calculPoid(int x, int y, Plateau plateau, int direction, int joueur, float poid) {

        if (MONTAGNE == plateau.testCasePlateau(modifX(x, direction), modifY(y, direction), 2, plateau)) {
            poid = (float) (calculPoid(modifX(x, direction), modifY(y, direction), plateau, direction, joueur, poid) - 0.9);

        } else if (joueur == plateau.testCasePlateau(modifX(x, direction), modifY(y, direction), 2, plateau)) {
            poid = (float) (calculPoid(modifX(x, direction), modifY(y, direction), plateau, direction, joueur, poid) + 1);
        } else if (invJoueur(joueur) == plateau.testCasePlateau(modifX(x, direction), modifY(y, direction), 2, plateau)) {
            poid = (float) (calculPoid(modifX(x, direction), modifY(y, direction), plateau, direction, joueur, poid) - 1);
        }
        return poid;

    }

    public boolean testMouvementMontagne(int x, int y, Plateau plateau, int direction, int joueur) {
        float poid = 1;
        if (plateau.testCasePlateau(x, y, 2, plateau) == MONTAGNE) {
            poid = calculPoid(x, y, plateau, direction, joueur, poid);
            if (poid > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean testBord(int x, int y, Plateau plateau) {
        return x == 0 || y == 0 || (y - 1 == plateau.getHauteur()) || x - 1
                == plateau.getLongueur();
    }

    public boolean testEntreePion(int x, int y, int noPion, Plateau plateau, int joueur, int direction) {
        if (testCasePlateau(noPion, noPion, joueur, plateau) == joueur && testBord(x, y, plateau)) {
            if (plateau.testCasePlateau(x, y, 2, plateau) == VIDE) {
                return true;
            } else if (plateau.testCasePlateau(x, y, 2, plateau) == MONTAGNE && testMouvementMontagne(x, y, plateau, direction, joueur)) {
                return true;
            }
        }

        return false;
    }

    public boolean testBougerPiece(int x1, int y1, int x2, int y2, Plateau plateau, int direction) {
        if (plateau.getCasePlateau()[x1][y1].getTypeContenue() == ELEPHANT || plateau.getCasePlateau()[x1][y1].getTypeContenue() == RHYNOCEROS) {
            if (testCasePlateau(x1, y1, 2, plateau) == -1 || testCasePlateau(x2, y2, 2, plateau) == -1) {
                return false;
            }
            if (direction == ((PionJoueur) plateau.getCasePlateau()[x1][y1].getPiece()).getDirection()) {
                if (x1 == x2 && (y1 == y2 + 1 || y1 == y2 - 1)) {

                }
            }
        }
        return false;
    }

    public void bougerPiece(int x1, int y1, int x2, int y2, Plateau plateau, int direction) {

    }

    public void entreePion(int x, int y, int noPion, Plateau plateau, int joueur, int direction) {
        if (testEntreePion(x, y, noPion, plateau, joueur, direction)) {
            if (plateau.testCasePlateau(x, y, 2, plateau) == VIDE) {
                if (joueur == RHYNOCEROS) {

                } else {
                    System.out.println("Elephant en" + x + " " + y);

                    plateau.caseElephant[noPion].setTypeContenue(VIDE);
                    plateau.casePlateau[x][y].setTypeContenue(ELEPHANT);

                    Piece piece = plateau.caseElephant[noPion].getPiece();
                    plateau.casePlateau[x][y].setPiece(piece);
                    plateau.caseElephant[noPion].setPiece(null);
                }

            } else if (plateau.testCasePlateau(x, y, 2, plateau) == MONTAGNE && testMouvementMontagne(x, y, plateau, direction, joueur)) {

            }
        }
    }

    public void afficherPlateau() {

        for (int i = 0; i < this.longueur + 8; i++) {
            System.out.print("*");
        }
        System.out.print("\n*");
        for (int i = 0; i < this.longueur + 6; i++) {
            System.out.print(" ");
        }
        System.out.print("*\n");
        for (int j = 0; j < this.hauteur; j++) {
            System.out.print("* ");
            System.out.print(+this.getCaseElephant()[j].getTypeContenue());
            System.out.print(" ");
            for (int i = 0; i < this.longueur; i++) {
                System.out.print(+this.getCasePlateau()[j][i].getTypeContenue());
            }
            System.out.print(" ");
            System.out.print(+this.getCaseRhino()[j].getTypeContenue());
            System.out.print(" *\n"); 
        }
        System.out.print("*");
        for (int i = 0; i < this.longueur + 6; i++) {
            System.out.print(" ");
        }
        System.out.print("*\n");
        for (int i = 0; i < this.longueur + 8; i++) {
            System.out.print("*");
        }
    }
}
