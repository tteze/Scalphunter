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

    private int health;
    private int resources;
    private Card[] deck;

    public Player(Card[] deck) {
        health = 10;
        resources = 0;
        this.deck = deck;
    }

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

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
    
    

}
