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
        if(move.getClass()==MoveSommon.class){
            
        if (move.getPlayer().getResources() >= move.getCard().getCost()) {
            for (int i = 0; i < this.getX(); i++) {
                if (move.getCard() == this.getBoard(i, move.myHand())) {
                    for (int j = 0; j < this.getX(); j++) {
                        /*  on regarde si il y a une place disponible sur le terrain
                        */
                        if (this.getBoard(j, move.myGround()) == null) {
                            /*  Cette carte passe de la ligne main à la ligne terrain
                            et le joueur perd le nombre de ressources correspondant
                            au coût de la carte.
                            */
                            this.setBoard(i, move.myHand(), null);
                            this.setBoard(j, move.myGround(), move.getCard());
                            move.getPlayer().setResources(move.getPlayer().getResources() - move.getCard().getCost());
                            break;
                        }
                    }
                }
            }
        }
        }else if(move.getClass()== MoveAttack.class){
        
        }else if(move.getClass()== MoveDefense.class){
        
        }
    }
}
