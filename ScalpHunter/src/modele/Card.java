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
    private boolean sommon;
    private boolean selected;

    // constructeur
    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.sommon=false;
        this.selected=false;
    }
    
    // getters et setters
    public boolean isSommon() {
        return sommon;
    }

    public void setSommon(boolean sommon) {    
        this.sommon = sommon;
    }

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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
