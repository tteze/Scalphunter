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
public class MoveSommon extends Move{
    // constructeur
    public MoveSommon(Game current) {
        super(current);
    }

    // fonctions
    @Override
    public void action(Card c, Player p) {
        /*  initialise de quel côté on se trouve
        */
        int hand = this.myHand(p);
        int ground = this.myGround(p);
        /*  au debut de cette phase, le joueur actif gagne x ressources
         ou x est le tour de jeu en cours.
         */
        p.setResources(p.getResources() + this.getCurrent().getRound());
        /*  si il a au moins autant de ressources que le coût de la carte
         */
        if (p.getResources() >= c.getCost()) {
            for (int i = 0; i < this.getCurrent().getBoardGame().getX(); i++) {
                if (c == this.getCurrent().getBoardGame().getBoard(i, hand)) {
                    for (int j = 0; j < this.getCurrent().getBoardGame().getX(); j++) {
                        /*  on regarde si il y a une place disponible sur le terrain
                         */
                        if (this.getCurrent().getBoardGame().getBoard(j, ground) == null) {
                            /*  Cette carte passe de la ligne main à la ligne terrain
                             et le joueur perd le nombre de ressources correspondant
                             au coût de la carte.
                             */
                            this.getCurrent().getBoardGame().setBoard(i, hand, null);
                            this.getCurrent().getBoardGame().setBoard(j, ground, c);
                            p.setResources(p.getResources() - c.getCost());
                            break;
                        }
                    }
                }
            }
        }
        /*  à la fin de cette phase, le joueur actif perd les ressources
         qu'il lui reste.
         */
        p.setResources(0);
    }

}
