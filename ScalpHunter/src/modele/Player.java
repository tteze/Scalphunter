/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Théophile
 */
public abstract class Player {

    // attributs
    private int id;
    private int health;
    private int resources;
    private ArrayList<Card> deck;

    // constructeur
    public Player(ArrayList<Card> deck, int id) {
        this.id = id;
        this.health = 10;
        this.resources = 0;
        this.deck = deck;
    }

    // getters et setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void untired(){
        for(int i=0;i<this.deck.size();i++){
            if(this.deck.get(i).getClass()==Minion.class){
                 ((Minion)this.deck.get(i)).setTired(false);
            }
        }
    }
    
        public int myHand() {
        if (this.getId() == 1) {
            return 0;
        } else {
            return 5;
        }
    }

    public int myGround() {
        if (this.getId() == 1) {
            return 1;
        } else {
            return 4;
        }
    }
    
    public int myFront() {
        if (this.getId() == 1) {
            return 2;
        } else {
            return 3;
        }
    }
    
    public void unAttack(Board board){
        for(int a=0;a<this.deck.size();a++)
            if(((Minion)this.deck.get(a)).isInAttack())
                for (int i = 0; i < board.getX(); i++) 
                    if (this.getDeck().get(a) == board.getBoard(i,this.myFront()))
                        for (int j = 0; j < board.getX(); j++) 
                            /*  on regarde si il y a une place disponible sur le terrain
                            */
                            if (board.getBoard(j, this.myFront()) == null) {
                                /*  Cette carte passe de la ligne terrain à la ligne front
                                */
                                board.setBoard(i, this.myGround(), null);
                                board.setBoard(j, this.myFront(), this.deck.get(a));
                                ((Minion)this.getDeck().get(a)).setInAttack(false);
                                break;
                            }
                        
                    
                
    }
    
    // fonctions
    public abstract ArrayList<MoveSommon> Sommon(Game g);

    public abstract ArrayList<MoveAttack> PlayAttack(Game g);

    public abstract ArrayList<MoveDefense> PlayDefense(Game g,ArrayList<MoveAttack> attacks);
}
