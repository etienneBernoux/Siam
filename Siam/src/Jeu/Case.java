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
public class Case {

    private int x;
    private int y;
    private int typeContenue;
    private Piece piece;

    public static final int RHYNOCEROS = 0;
    public static final int ELEPHANT = 1;
    public static final int MONTAGNE = 2;
    public static final int VIDE = 2;

    public Case(int x, int y, int typeContenue) {
        this.x = x;
        this.y = y;
        this.typeContenue = typeContenue;

        switch (typeContenue) {
            case 0:
                this.piece = new Rhynoceros();
                break;
            case 1:
                this.piece = new Elephant();
                break;
            case 2:
                this.piece = new Montagne();
                break;
            case 3:
                this.piece = null;
                break;

        }

    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    public int getTypeContenue() {
        return typeContenue;
    }
    

}
