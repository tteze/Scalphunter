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
public class GameMonteCarlo extends Game implements Cloneable{
    private int phase;

    public GameMonteCarlo(PlayerAI player1, PlayerAI player2) {
        super(player1, player2);
        this.phase=0;
    }
    
    public void nextphase(){
        this.phase++;
        this.phase%=3;
    }
    
    public void PlayaPhase(){
        Player p=this.getPlayer();
        switch(this.phase){
            case 0://defense
                this.setRound(this.getRound()+1);
                p=this.nextPlayer();
                ArrayList<MoveAttack> attacks=new ArrayList();
                for(int i=0;i<this.getBoardGame().getX();i++)
                    if(this.getBoardGame().getBoard(i, p.myFront())!=null)
                        attacks.add(new MoveAttack(this.getBoardGame().getBoard(i, p.myFront()),p));
                this.defenseRound(p, attacks);
                this.nextphase();
                break;
            case 1://sommon
                p.setResources(p.getResources()+this.getRound());
                this.sommonRound(p);
                this.nextphase();
                break;
            case 2://attack
                this.attackRound(p);
                this.nextphase();
                break;
        }
    }
    
    @Override
    public Object clone() {
        GameMonteCarlo copie = (GameMonteCarlo) super.clone();
        copie.phase=this.phase;
        return copie;
    }
}
