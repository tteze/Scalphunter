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
    private boolean tired;

    public Minion(String name, int cost, int attack, int defense) {
        super(name, cost);
        this.attack = attack;
        this.defense = defense;
        this.tired=false;
    }

    public int Fight(Minion opponent) {
        if(this.attack>this.defense){
            return 1;
        }else if(this.attack<this.defense){
            return 2;
        }
        return 0;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }
    
    @Override
    public Object clone(){
        Minion copie = (Minion) super.clone();
        copie.attack=this.attack;
        copie.defense=this.defense;
        copie.tired=this.tired;
        return copie;
    }
    
    
    
    

}
