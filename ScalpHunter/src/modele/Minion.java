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
    private boolean inAttack;

    public Minion(String name, int cost, int attack, int defense) {
        super(name, cost);
        this.attack = attack;
        this.defense = defense;
        this.tired = false;
        this.inAttack = false;
    }

    public int Fight(Minion opponent) {
        if (this.attack > opponent.getDefense()) {
            return 1;
        }
        if (this.attack < opponent.getDefense()) {
            return 2;
        }
        if (this.attack == opponent.getDefense()) {
            return 0;
        }
        return -1;
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

    public boolean isInAttack() {
        return inAttack;
    }

    public void setInAttack(boolean inAttack) {
        this.inAttack = inAttack;
    }

    @Override
    public Object clone() {
        Minion copie = (Minion) super.clone();
        copie.attack = this.attack;
        copie.defense = this.defense;
        copie.tired = this.tired;
        return copie;
    }

}
