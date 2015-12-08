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
public class MoveDefense extends Move {

    private Player player_attack;
    private Card card_attack;
    //constructeur

    public MoveDefense(Player player_attack, Card card_attack, Card card, Player player) {
        super(card, player);
        this.player_attack = player_attack;
        this.card_attack = card_attack;
    }

    // fonctions
    public Card getCard_attack() {
        return card_attack;
    }

    public Player getPlayer_attack() {
        return player_attack;
    }

}
