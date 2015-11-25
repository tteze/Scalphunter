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
    private Card[][] board;
    private int state;
    private int x;

    public Board() {
        this.x=4;
        this.state=6;
        this.board = new Card[this.x][this.state];
    }
    
    public void applyMove(Move move){
        //TODO
    } 
    
    
}
