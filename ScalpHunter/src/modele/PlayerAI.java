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
public class PlayerAI extends Player {

    public PlayerAI(ArrayList<Card> deck, int id) {
        super(deck, id);
    }

    @Override
    public MoveAttack PlayAttack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MoveDefense PlayDefense(ArrayList<MoveAttack> attacks) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
