/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalphunter;

import java.util.ArrayList;
import modele.*;
import vue.*;
/**
 *
 * @author Théophile
 */
public class ScalpHunter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       ArrayList<Card> deck1,deck2;
       DeckCreator dc=new DeckCreator();
       deck1=dc.get_random_deck(4);
       deck2=dc.get_random_deck(4);
       Player player1=new PlayerHuman(deck1,1);
       Player player2=new PlayerHuman(deck2,2);
       Game g=new Game(player1,player2);
       Fenetre f=new Fenetre(g);
       f.getG().play();
    }

}
