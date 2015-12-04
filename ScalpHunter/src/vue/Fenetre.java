/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Control;
import javax.swing.JFrame;
import modele.Game;
import modele.Player;
import modele.PlayerHuman;

/**
 *
 * @author Théophile
 */
public class Fenetre extends JFrame {
    VueBoard v;
    Game g;
    Control c;
    
    public Fenetre(Game g){
        this.g=g;
        this.c=new Control(this);
        this.g.setC(this.c);
        this.v=new VueBoard(g.getBoardGame(),600,600,this.c);
        if(g.getPlayer1().getClass()==PlayerHuman.class){
            ((PlayerHuman)g.getPlayer1()).setC(this.getC());
        }
        if(g.getPlayer2().getClass()==PlayerHuman.class){
            ((PlayerHuman)g.getPlayer2()).setC(this.getC());
        }
        this.initialisation();
    }

    public VueBoard getV() {
        return v;
    }

    public Control getC() {
        return c;
    }

    public Game getG() {
        return g;
    }
    
    
    
    
    private void initialisation(){
       this.add(v);
       this.setTitle("ScalpHunter");
       this.pack();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setLocationRelativeTo(null);
    }
}
