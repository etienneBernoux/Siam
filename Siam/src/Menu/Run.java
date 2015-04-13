/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.CardLayout;
import javax.swing.*;

/**
 *
 * @author cyril_000
 */
public class Run extends JFrame{
    CardLayout c1= new CardLayout();
    JPanel content = new JPanel();
    //Liste des noms de nos conteneurs pour la pile de cartes
    String[] listContent = {"Menu", "Regles", "Joueurs"};
    int indice = 0;
    public Run (){
        this.setTitle("Siam");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        PannelMenu menu= new PannelMenu(this);
        PannelNomJoueur joue= new PannelNomJoueur(this);
        PannelRegles regles=new PannelRegles(this);
        
        content.setLayout(c1);
        //On ajoute les cartes à la pile avec un nom pour les retrouver
        content.add(menu, listContent[0]);
        content.add(regles, listContent[1]);
        content.add(joue, listContent[2]);
        this.change(listContent[0]);
        this.setVisible(true);
        
    }
    public void change(String type){
        c1.show(content, type);
    }
   
}
