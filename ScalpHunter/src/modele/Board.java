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
public class Board {
    // attributs
    private Card[][] board;
    private int state;
    private int x;

    // constructeur
    public Board() {
        this.x = 4;
        this.state = 6;
        this.board = new Card[this.x][this.state];
    }
    
    // getters et setters
    public Card getBoard(int i, int j) {
        return this.board[i][j];
    }

    public void setBoard(int i, int j, Card c) {
        this.board[i][j] = c;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    

    // fonctions
    public void applyMove(Move move) {
        //TODO
    }

}
