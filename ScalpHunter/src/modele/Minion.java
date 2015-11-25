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
public class Minion extends Card {

    private int attack;
    private int defense;

    public Minion(String name, int cost, int attack, int defense) {
        super(name, cost);
        this.attack = attack;
        this.defense = defense;
    }

    public void Fight(Minion opponent) {
        //TODO
    }

}
