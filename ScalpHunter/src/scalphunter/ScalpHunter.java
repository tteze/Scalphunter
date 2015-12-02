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
    public static void main(String[] args) {
       ArrayList<Card> deck1,deck2;
       deck1=new ArrayList();
       deck2=new ArrayList();
       deck1.add(new Minion("Sherif", 3, 2, 4));
       deck1.add(new Minion("Billy the Kid", 1, 1, 1));
       deck1.add(new Minion("Lucky Luke", 5, 4, 1));
       deck1.add(new Minion("Joe Dalton",2, 3, 2));
       deck2.add(new Minion("Sherif", 3, 2, 4));
       deck2.add(new Minion("Billy the Kid", 1, 1, 1));
       deck2.add(new Minion("Lucky Luke", 5, 4, 1));
       deck2.add(new Minion("Joe Dalton",2, 3, 2));
       Player player1=new PlayerHuman(deck1,1);
       Player player2=new PlayerHuman(deck2,2);
       Game g=new Game(player1,player2);
       Fenetre f=new Fenetre(g);
    }

}
