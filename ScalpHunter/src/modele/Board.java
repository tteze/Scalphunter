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
public class Board implements Cloneable{
    // attributs
    private Card[][] board;
    private int state;
    private int x;

    // constructeur
    public Board(Player player1, Player player2) {
        this.x = 4;
        this.state = 6;
        this.board = new Card[this.x][this.state];
        
        for(int i=0;i<this.x && i<player1.getDeck().size();i++)
            this.board[i][0]=player1.getDeck().get(i);
        
        for(int u=1;u<5;u++)
            for(int i=0;i<this.x;i++)
                this.board[i][u]=null;
        
        for(int i=0;i<this.x && i<player2.getDeck().size();i++)
            this.board[i][5]=player2.getDeck().get(i);
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
    
    public void remove_card(Card c, Player p){
        for(int i=0;i<this.x;i++)
            for(int u=0;u<this.state;u++)
                if(this.board[i][u]==c){
                     this.board[i][u]=null;
                     p.getDeck().remove(c);
                }
    }

    // fonctions
    public void applyMove(Move move) {
        if(move.getClass()==MoveSommon.class){
            
        if (move.getPlayer().getResources() >= move.getCard().getCost()) {
            for (int i = 0; i < this.x; i++) {
                if (move.getCard() == this.getBoard(i, move.getPlayer().myHand())) {
                    for (int j = 0; j < this.x; j++) {
                        /*  on regarde si il y a une place disponible sur le terrain
                        */
                        if (this.getBoard(j, move.getPlayer().myGround()) == null) {
                            /*  Cette carte passe de la ligne main à la ligne terrain
                            et le joueur perd le nombre de ressources correspondant
                            au coût de la carte.
                            */
                            this.setBoard(i, move.getPlayer().myHand(), null);
                            this.setBoard(j, move.getPlayer().myGround(), move.getCard());
                            move.getPlayer().setResources(move.getPlayer().getResources() - move.getCard().getCost());
                            move.getCard().setSommon(true);
                            break;
                        }
                    }
                }
            }
        }
        }else if(move.getClass()== MoveAttack.class){
            if(move.getCard().getClass()==Minion.class){
                for (int i = 0; i < this.x; i++) {
                    if (move.getCard() == this.getBoard(i, move.getPlayer().myGround())) {
                        for (int j = 0; j < this.x; j++) {
                            /*  on regarde si il y a une place disponible sur le terrain
                            */
                            if (this.getBoard(j, move.getPlayer().myFront()) == null) {
                                /*  Cette carte passe de la ligne terrain à la ligne front
                                */
                                this.setBoard(i, move.getPlayer().myGround(), null);
                                this.setBoard(j, move.getPlayer().myFront(), move.getCard());
                                ((Minion)move.getCard()).setInAttack(true);
                                break;
                            }
                        }
                    }
                }
            }
          }else if(move.getClass()== MoveDefense.class){
            if(!((Minion) move.getCard()).isTired()){
            switch(((Minion)((MoveDefense)move).getCard_attack()).Fight((Minion) move.getCard())){
                case 0: // suppression des deux cartes
                    this.remove_card(move.getCard(), move.getPlayer());
                    this.remove_card(((MoveDefense)move).getCard_attack(), ((MoveDefense)move).getPlayer_attack());
                    break;
                case 1: // suppression de la carte defenseur
                    this.remove_card(move.getCard(), move.getPlayer());
                    break;
                case 2: // suppression de la carte attaquante
                    this.remove_card(((MoveDefense)move).getCard_attack(), ((MoveDefense)move).getPlayer_attack());
                    break;   
            }
            ((Minion)((MoveDefense)move).getCard_attack()).setTired(true);
            ((Minion)((MoveDefense)move).getCard()).setTired(true);
            }
        }
    }
    
    public Object clone(){
        Board copie = null;
        try {
            copie = (Board) super.clone();
        }catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        copie.board=this.board.clone();
        copie.state=this.state;
        copie.x=this.x;
        return copie;
    }
}
