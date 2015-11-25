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
public abstract class Card {

    private String name;
    private int cost;

    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

}
