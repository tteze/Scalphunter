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
public class Game {

    // attributs

    private Player player1;
    private Player player2;
    private boolean current_player;
    private Board board_game;
    private int round; // TODO modifier le diagramme de classe
    Control c;

    // constructeur
    public Game(Player player1, Player player2) {
        this.round = 0; // initialise le tour de jeu à 0
        this.player1 = player1;
        this.player1.setId(1);
        this.player2 = player2;
        this.player2.setId(2);
        this.current_player = false;
        board_game = new Board(player1,player2);
        this.c=null;
    }

    public void setC(Control c) {
        this.c = c;
    }

    // getters et setters
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isCurrent_player() {
        return current_player;
    }

    
    
    public Player getPlayer() {
        if (this.current_player) {
            return this.player2;
        }
        return this.player1;
    }
    
    public Player getnoneCurrent_player() {
        if (this.current_player) {
            return this.player1;
        }
        return this.player2;
    }

    public void setCurrent_player(boolean current_player) {
        this.current_player = current_player;
    }

    public Board getBoardGame() {
        return board_game;
    }

    public void setBoardGame(Board board_game) {
        this.board_game = board_game;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    // fonctions
    public Player isEnd() {
        if (this.player1.getHealth() <= 0) {
            return this.player1;
        } else if (this.player2.getHealth() <= 0) {
            return this.player2;
        }
        return null;
    }

    public Player nextPlayer() {
        if (this.current_player) {
            this.current_player = false;
            return this.player1;
        }
        this.current_player = true;
        return this.player2;
    }

    private void sommonRound(Player player) {
        ArrayList<MoveSommon> s=null;
        s=player.Sommon(this);
        for (int i=0;i<s.size();i++) {
            this.board_game.applyMove(s.get(i));
        }
    }

    private ArrayList<MoveAttack> attackRound(Player player) {
        ArrayList<MoveAttack> a = null;
        a = player.PlayAttack(this);
        for(int i=0;i<a.size();i++) {
            this.board_game.applyMove(a.get(i));
        }
        return a;
    }

    private void defenseRound(Player player, ArrayList<MoveAttack> attacks) {
        ArrayList<MoveDefense> d = null;
        d = player.PlayDefense(this,attacks);
        for(int i=0;i<d.size();i++) {
            this.board_game.applyMove(d.get(i));
        }
        for(int i=0;i<attacks.size();i++){
            if(!((Minion) attacks.get(i).getCard()).isTired()){
                player.setHealth(player.getHealth()-((Minion) attacks.get(i).getCard()).getAttack());
                ((Minion) attacks.get(i).getCard()).setTired(true);
            }
        }
    }

    private void cond_human(Player player) throws InterruptedException{
        if(player.getClass()==PlayerHuman.class)
            while(!c.get_continuef());
        else
            Thread.sleep(60000);
    }
    
    
    public Player play() throws InterruptedException {
        Player winner=null;
        Player player;
        ArrayList<MoveAttack> attacks = new ArrayList();
        for(int i=3;(winner=this.isEnd())==null;i++){
            this.setRound((int)i/2);
            player=nextPlayer();
            c.update();
            if(attacks.size()>0){
                this.cond_human(player);
                this.defenseRound(player, attacks);
                if((winner=this.isEnd())!=null){
                    return winner;
                }    
            }
            attacks.clear();
            player.untired();
            player.unAttack(board_game);
            player.setResources(player.getResources() + this.getRound());
            c.nextround();
            c.update();
            this.cond_human(player);
            this.sommonRound(player);
            c.nextround();
            if(player.can_attack()){
                c.update();
                this.cond_human(player);
                attacks=this.attackRound(player);
            }
            c.nextround();
            c.update();
        }
        return winner;
    }

}
