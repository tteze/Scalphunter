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
public abstract class Move {

    // attributs
    Card card;
    Player player;

    // constructeur

    public Move(Card card, Player player) {
        this.card = card;
        this.player = player;
    }
    public Card getCard() {    
        return card;
    } 

    public void setCard(Card card) {
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    // getters et setters
    public void setPlayer(Player player) {    
        this.player = player;
    }

    // fonctions

    public int myHand() {
        if (this.player.getId() == 1) {
            return 0;
        } else {
            return 5;
        }
    }

    public int myGround() {
        if (this.player.getId() == 1) {
            return 1;
        } else {
            return 4;
        }
    }
}
