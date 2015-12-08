/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controleur.Control;
import java.util.ArrayList;

/**
 *
 * @author Théophile
 */
public class PlayerHuman extends Player {

    private Control c;

    public PlayerHuman(ArrayList<Card> deck, int id) {
        super(deck, id);
        this.c = null;
    }

    public void setC(Control c) {
        this.c = c;
    }

    @Override
    public ArrayList<MoveAttack> PlayAttack(Game g) {
        ArrayList<MoveAttack> m = new ArrayList();
        ArrayList<Card> plays = this.c.get_cards();
        for (int i = 0; i < plays.size(); i++) {
            m.add(new MoveAttack(plays.get(i), this));
        }
        return m;
    }

    @Override
    public ArrayList<MoveDefense> PlayDefense(Game g, ArrayList<MoveAttack> attacks) {
        ArrayList<MoveDefense> d = new ArrayList();
        ArrayList<Card> plays = this.c.get_cards();
        ArrayList<Card> targets = this.c.get_cards2();
        for (int i = 0; i < plays.size() && i < targets.size(); i++) {
            d.add(new MoveDefense(g.getnoneCurrent_player(), targets.get(i), plays.get(i), this));
        }
        return d;
    }

    @Override
    public ArrayList<MoveSommon> Sommon(Game g) {
        ArrayList<MoveSommon> s = new ArrayList();
        ArrayList<Card> plays = this.c.get_cards();
        for (int i = 0; i < plays.size(); i++) {
            s.add(new MoveSommon(plays.get(i), this));
        }
        return s;
    }

}
