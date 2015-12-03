/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Random;

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
        MoveAttack a=null;
        Random r1=new Random();
        int i=r1.nextInt(this.getDeck().size());
        if(this.getDeck().get(i).isSommon() && !((Minion)this.getDeck().get(i)).isInAttack())
            if(this.getDeck().get(i).getClass()==Minion.class)
                a=new MoveAttack(this.getDeck().get(i),this);
        return a;
    }

    @Override
    public MoveDefense PlayDefense(ArrayList<MoveAttack> attacks) {
        MoveDefense d=null;
        for(int i=0;i<attacks.size();i++)
            if(!((Minion)attacks.get(i).getCard()).isTired())
                for(int u=0;u<this.getDeck().size();u++)
                    if(this.getDeck().get(u).getClass()==Minion.class)
                        if(this.getDeck().get(u).isSommon() && !((Minion)this.getDeck().get(u)).isTired())
                            if(((Minion)this.getDeck().get(u)).getDefense()>=((Minion)attacks.get(i).getCard()).getAttack()){
                                d=new MoveDefense(attacks.get(i).getPlayer(),attacks.get(i).getCard(),this.getDeck().get(u),this);
                                return d;
                            }
        
        return d;
    }

    @Override
    public MoveSommon Sommon() {
        MoveSommon s=null;
        for(int i=0;i<this.getDeck().size();i++){
            if(this.getDeck().get(i).getCost()<=this.getResources()){
                s=new MoveSommon(this.getDeck().get(i),this);
                break;
            }
        }
        return s;
    }

}
