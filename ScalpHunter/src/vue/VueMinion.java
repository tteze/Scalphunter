/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import modele.Minion;

/**
 *
 * @author Théophile
 */
public class VueMinion extends JComponent{
    Minion m;
    int longueur;
    int largeur;
    VueMinion(Minion m, int longueur,int largeur) {
        this.m=m;
        this.longueur=longueur;
        this.largeur=largeur;
    }

    @Override
    public void paintComponent(Graphics p1) {
        Graphics2D p = (Graphics2D) p1;
        p.setBackground(Color.white);
        p.setColor(Color.black);
        p.drawString( "Name" , 5 , 5 );
        p.setColor(Color.blue);
        p.drawString( "Cost" , this.longueur-20 , 5 );
        p.setColor(Color.red);
        p.drawString( "Attack" , 5 , this.largeur-10 );
        p.setColor(Color.green);
        p.drawString( "Defense" , this.longueur-20 , this.largeur-10 );
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.longueur,this.largeur);
    }
}
