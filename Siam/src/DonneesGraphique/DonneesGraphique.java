/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DonneesGraphique;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author cyril_000
 */
public class DonneesGraphique {
    private ArrayList<Image> imageElephant;
    private ArrayList<Image> imageRhyno;
    private Image imageMontagne;
    private Image imagePlateau;
    
    DonneesGraphique(){
        //chargement des images
        
    }
    public Image getImage(int type, int direction){
        switch (type){
            case 0:
                return imageRhyno.get(direction);
            case 1:
                return imageElephant.get(direction);
            case 2:
                return imageMontagne;
        }   
        return null;
    }
}
