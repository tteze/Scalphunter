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
public class PlayerMonteCarlo extends Player {
    private int division;

    private Player getequivPlayer(Game g) {
        if (this.getId() == 1) {
            return g.getPlayer1();
        }
        return g.getPlayer2();
    }

    private int Play_GameMonteCarlo(GameMonteCarlo g) {
        // on utilisera seulement le board pour le déroulement de la partie
        int percent = 0;
        Player p = null;
        if ((p = g.isEnd()) == null) {
            for (int i = 0; i < this.division; i++) {
                GameMonteCarlo copy = (GameMonteCarlo) g.clone();
                copy.PlayaPhase();
                percent += this.Play_GameMonteCarlo(copy);
            }
            percent /= this.division;
        } else {
            if (p == this.getequivPlayer(g)) {
                percent = 100;
            } else {
                percent = 0;
            }
        }
        return percent;
    }

    private GameMonteCarlo copieAIGame(Game g) {
        PlayerAI p1 = new PlayerAI((ArrayList<Card>) g.getPlayer1().getDeck().clone(), g.getPlayer1().getId());
        PlayerAI p2 = new PlayerAI((ArrayList<Card>) g.getPlayer2().getDeck().clone(), g.getPlayer2().getId());
        p1.setHealth(g.getPlayer1().getHealth());
        p1.setResources(g.getPlayer1().getResources());
        p2.setHealth(g.getPlayer2().getHealth());
        p2.setResources(g.getPlayer2().getResources());
        GameMonteCarlo copy = new GameMonteCarlo(p1, p2);
        copy.setCurrent_player(g.isCurrent_player());
        copy.setRound(g.getRound());
        copy.setBoardGame((Board) g.getBoardGame().clone());
        return copy;
    }

    public PlayerMonteCarlo(ArrayList<Card> deck, int id,int division) {
        super(deck, id);
        this.division=division;
    }

    @Override
    public ArrayList<MoveSommon> Sommon(Game g) {
        ArrayList<MoveSommon> s= null;
        ArrayList<MoveSommon> bestSommon =null;
        int percent_bestSommon=0,percent=0;
        GameMonteCarlo copy;
        for(int i=0;i<this.division;i++){
            copy=this.copieAIGame(g);
            s=copy.getPlayer().Sommon(g);
            this.Play_GameMonteCarlo(copy);
            percent=this.Play_GameMonteCarlo(copy);
            if(percent>percent_bestSommon){
                bestSommon=s;
                percent_bestSommon=percent;
            }
        }
        return bestSommon;
    }

    @Override
    public ArrayList<MoveAttack> PlayAttack(Game g) {
        ArrayList<MoveAttack> a= null;
        ArrayList<MoveAttack> bestAttack =null;
        int percent_bestAttack=0,percent=0;
        GameMonteCarlo copy;
        for(int i=0;i<this.division;i++){
            copy=this.copieAIGame(g);
            a=copy.getPlayer().PlayAttack(g);
            copy.PlayaPhase();
            percent=this.Play_GameMonteCarlo(copy);
            if(percent>percent_bestAttack){
                bestAttack=a;
                percent_bestAttack=percent;
            }
        }
        return bestAttack;
    }

    @Override
    public ArrayList<MoveDefense> PlayDefense(Game g, ArrayList<MoveAttack> attacks) {
        ArrayList<MoveDefense> d= null;
        ArrayList<MoveDefense> bestDefense =null;
        int percent_bestDefense=0,percent=0;
        GameMonteCarlo copy;
        for(int i=0;i<this.division;i++){
            copy=this.copieAIGame(g);
            d=copy.getPlayer().PlayDefense(g,attacks);
            copy.PlayaPhase();
            percent=this.Play_GameMonteCarlo(copy);
            if(percent>percent_bestDefense){
                bestDefense=d;
                percent_bestDefense=percent;
            }
        }
        return bestDefense;
    }

}
