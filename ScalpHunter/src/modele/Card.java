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
public abstract class Card implements Cloneable{
    // attributs
    private String name;
    private int cost;

    // constructeur
    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    // getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public Object clone(){
        Card copie = null;
        try {
            copie = (Card) super.clone();
        }catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        copie.name=this.name;
        copie.cost=this.cost;
        return copie;
    }

}
