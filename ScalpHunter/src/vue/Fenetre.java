/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JFrame;
import modele.Game;
import modele.Player;

/**
 *
 * @author Théophile
 */
public class Fenetre extends JFrame{
    VueBoard v;
    Game g;
    
    public Fenetre(Game g){
        this.g=g;
        v=new VueBoard(g.getBoardGame(),700,700);
        this.initialisation();
    }
    
    private void initialisation(){
       this.add(v);
       this.setVisible(true);
       this.pack();
    }
}
