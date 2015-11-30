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
    

    // fonctions
    public MoveSommon Sommon() {
        //TODO
        return null;
    }

    public MoveAttack PlayAttack() {
        //TODO
        return null;
    }

    public MoveDefense PlayDefense(ArrayList<MoveAttack> attacks) {
        //TODO
        return null;
    }
}
