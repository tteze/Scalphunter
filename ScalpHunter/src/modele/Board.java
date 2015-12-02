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
    public Board(Player player1, Player player2) {
        this.x = 4;
        this.state = 6;
        this.board = new Card[this.x][this.state];
        
        for(int i=0;i<this.x && i<player1.getDeck().size();i++)
            this.board[i][0]=player1.getDeck().get(i);
        
        for(int u=1;u<5;u++)
            for(int i=0;i<this.x;i++)
                this.board[i][0]=null;
        
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
                if (move.getCard() == this.getBoard(i, move.myHand())) {
                    for (int j = 0; j < this.x; j++) {
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
            //TODO
            //la carte est avancée en zone de combat
        }else if(move.getClass()== MoveDefense.class){
            if(!((Minion) move.getCard()).isTired()){
            switch(((Minion)((MoveDefense)move).getCard_attack()).Fight((Minion) move.getCard())){
                case 0: // TODO égalité voir quoi faire
                    
                    break;
                case 1: // suppression de la carte defenseur
                    this.remove_card(move.getCard(), move.getPlayer());
                    break;
                case 2: // suppression de la carte attaquante
                    this.remove_card(((MoveDefense)move).getCard_attack(), ((MoveDefense)move).getPlayer_attack());
                    break;   
            }
            ((Minion)((MoveDefense)move).getCard_attack()).setTired(true);
            }
        }
    }
}
