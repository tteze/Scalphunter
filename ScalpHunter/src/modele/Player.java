/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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

    public MoveDefense PlayDefense() {
        //TODO
        return null;
    }

}
