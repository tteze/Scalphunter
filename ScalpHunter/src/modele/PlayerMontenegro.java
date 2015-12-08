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
public class PlayerMontenegro extends Player {

    private void play_move(Game g, ArrayList<Move> moves) {
        //todo
    }

    private Player getequivPlayer(Game g) {
        if (this.getId() == 1) {
            return g.getPlayer1();
        }
        return g.getPlayer2();
    }

    private int play_copygame(Game g, int division, ArrayList<Move> moves) {
        // on utilisera seulement le board pour le déroulement de la partie
        int percent = 0;
        moves.clear();
        Player p = null;
        if ((p = g.isEnd()) == null) {
            for (int i = 0; i < division; i++) {
                Game copy = this.copieAIGame(g);
                play_move(copy, moves);
                percent += this.play_copygame(copy, division, moves);
            }
            percent /= division;
        } else {
            if (p == this.getequivPlayer(g)) {
                percent = 100;
            } else {
                percent = 0;
            }
        }
        return percent;
    }

    private Game copieAIGame(Game g) {
        PlayerAI p1 = new PlayerAI((ArrayList<Card>) g.getPlayer1().getDeck().clone(), g.getPlayer1().getId());
        PlayerAI p2 = new PlayerAI((ArrayList<Card>) g.getPlayer2().getDeck().clone(), g.getPlayer2().getId());
        p1.setHealth(g.getPlayer1().getHealth());
        p1.setResources(g.getPlayer1().getResources());
        p2.setHealth(g.getPlayer2().getHealth());
        p2.setResources(g.getPlayer2().getResources());
        Game copy = new Game(p1, p2);
        copy.setCurrent_player(g.isCurrent_player());
        copy.setRound(g.getRound());
        copy.setBoardGame((Board) g.getBoardGame().clone());
        return copy;
    }

    public PlayerMontenegro(ArrayList<Card> deck, int id) {
        super(deck, id);
    }

    @Override
    public ArrayList<MoveSommon> Sommon(Game g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MoveAttack> PlayAttack(Game g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MoveDefense> PlayDefense(Game g, ArrayList<MoveAttack> attacks) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
