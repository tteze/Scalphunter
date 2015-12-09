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
        //todo
    }
    
    @Override
    public Object clone() {
        GameMonteCarlo copie = (GameMonteCarlo) super.clone();
        copie.phase=this.phase;
        return copie;
    }
}
