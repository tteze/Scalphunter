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
    public ArrayList<MoveAttack> PlayAttack(Game g) {
        ArrayList<MoveAttack> a=new ArrayList();
        ArrayList<Card> can_attack=new ArrayList();
        Random r=new Random();
        int compteur=0;
        for(int u=0;u<this.getDeck().size();u++)
            if(this.getDeck().get(u).getClass()==Minion.class)
                if(((Minion)this.getDeck().get(u)).isSommon() && !((Minion)this.getDeck().get(u)).isTired()){
                    compteur++;
                    can_attack.add(this.getDeck().get(u));
                }

        int alea=r.nextInt(compteur);
        ArrayList<Integer> mem=new ArrayList();
        for(int i=0;i<alea;i++){
                    int alea2;
                    do{
                       alea2=r.nextInt(compteur);
                    }while(mem.contains(alea2));
                    mem.add(alea2);
                    a.add(new MoveAttack(can_attack.get(alea2),this));
        }
        return a;
    }

    @Override
    public ArrayList<MoveDefense> PlayDefense(Game g,ArrayList<MoveAttack> attacks){
        ArrayList<MoveDefense> d=new ArrayList();
        for(int i=0;i<attacks.size();i++)
            if(!((Minion)attacks.get(i).getCard()).isTired())
                for(int u=0;u<this.getDeck().size();u++)
                    if(this.getDeck().get(u).getClass()==Minion.class)
                        if(this.getDeck().get(u).isSommon() && !((Minion)this.getDeck().get(u)).isTired())
                            if(((Minion)this.getDeck().get(u)).getDefense()>=((Minion)attacks.get(i).getCard()).getAttack())
                                d.add(new MoveDefense(attacks.get(i).getPlayer(),attacks.get(i).getCard(),this.getDeck().get(u),this));
        return d;
    }

    @Override
    public ArrayList<MoveSommon> Sommon(Game g) {
        ArrayList<MoveSommon> s=new ArrayList();
        int ress=this.getResources();
        for(int i=0;i<this.getDeck().size();i++){
            if(this.getDeck().get(i).getCost()<=ress){
                s.add(new MoveSommon(this.getDeck().get(i),this));
                ress-=this.getDeck().get(i).getCost();
            }
        }
        return s;
    }

}
