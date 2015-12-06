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
public class VueMinion{
    Minion m;
    int longueur;
    int largeur;
    VueMinion(Minion m, int longueur,int largeur) {
        this.m=m;
        this.longueur=longueur;
        this.largeur=largeur;
    }
    public void paint(Graphics2D p,int x,int y) {
        if(m.isTired())
            p.setColor(Color.ORANGE);
        else
            p.setColor(Color.white);
        p.fillRect(x, y, this.longueur, this.largeur);
        p.setColor(Color.black);
        p.drawString( m.getName() , 5+x , 15+y );
        p.setColor(Color.blue);
        p.drawString( ""+m.getCost() , this.longueur-10+x , 15+y );
        p.setColor(Color.red);
        p.drawString( ""+m.getAttack() , 5+x , this.largeur-10+y );
        p.setColor(Color.green);
        p.drawString( ""+m.getDefense() , this.longueur-10+x , this.largeur-10+y );
        if(m.isSelected()){
            p.setColor(Color.red);
            p.drawRect(x+1, y+1, this.longueur-2, this.largeur-2);
        }

    }
}
