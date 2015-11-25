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
public class Game {

    private Player player1;
    private Player player2;
    private boolean current_player;
    private Board board;
    private int round; // TODO modifier le diagramme de classe

    public Game(Player player1, Player player2) {
        this.round = 0; // initialise le tour de jeu à 0
        this.player1 = player1;
        this.player2 = player2;
        this.current_player = false;
        board = new Board();
    }

    private Player isEnd() {
        if(this.player1.getHealth()<=0)
            return this.player2;
        else if(this.player2.getHealth()<=0)
            return this.player1;
        return null;
    }

    private Player nextPlayer() {
        if(this.current_player){
            this.current_player=false;
            return this.player1;
        }
        this.current_player=true;
        return this.player2;
    }

    private void sommonRound(Player player) {
        MoveSommon s=null;
        while((s=player.Sommon())!=null){
            this.board.applyMove(s);
        }
    }

    private ArrayList<MoveAttack> attackRound(Player player) {
        ArrayList<MoveAttack> list_attack = null;
        MoveAttack a=null;
        while((a=player.PlayAttack())!=null){
            this.board.applyMove(a);
            list_attack.add(a);
        }
        return list_attack;
    }

    private void defenseRound(Player player, ArrayList<MoveAttack> attacks) {
        if(attacks!=null){
            MoveDefense d=null;
            while((d=player.PlayDefense(attacks))!=null){
                this.board.applyMove(d);
            }
        }
    }

    public Player play() {
        Player winner=null;
        Player player;
        ArrayList<MoveAttack> attacks=null;
        for(int i=2;(winner=this.isEnd())==null;i++){
            player=nextPlayer();
            this.defenseRound(player, attacks);
            player.setResources(player.getResources()+i/2);
            this.sommonRound(player);
            attacks=this.attackRound(player);
        }
        return winner;
    }

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

    public void setCurrent_player(boolean current_player) {
        this.current_player = current_player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    
    
}
