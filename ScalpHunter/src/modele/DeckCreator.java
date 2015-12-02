/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Théophile
 */
public class DeckCreator {
    private Excel_reader r;
    
    public DeckCreator(){
       this.r=new Excel_reader();
    }
    
    public ArrayList<Card> get_random_deck(int nb_cartes){
       ArrayList<Card> deck=new ArrayList();
       Random random= new Random();
       for(int i=0;i<nb_cartes;i++)
            deck.add(this.r.getCards().get(random.nextInt(this.r.getCards().size())));
       return (ArrayList<Card>) deck.clone();
    }
    
    public ArrayList<Card> create_deck(int nb_cartes){
       //TODO
       return null;
    }
}
