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
        //TODO
        return null;
    }

    private Player nextPlayer() {
        //TODO
        return null;
    }

    private void sommonRound() {
        //TODO
    }

    private ArrayList<MoveAttack> attackRound() {
        //TODO
        return null;
    }

    private void defenseRound(ArrayList<MoveAttack> attacks) {
        //TODO
    }

    public Player play() {
        //TODO
        return null;
    }

}
