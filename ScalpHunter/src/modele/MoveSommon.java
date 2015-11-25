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
        /*  au debut de cette phase, le joueur actif gagne x ressources
            ou x est le tour de jeu en cours.
        */
        p.setResources(p.getResources()+this.getCurrent().getRound());
        /*  le joueur actif peut depenser des ressources pour jouer une
            carte de sa main. Cette carte passe de la ligne main à la ligne
            terrain.
        */
        /*  si il a au moins autant de ressources que le coût de la carte,
            il perd le nombre de ressources correspondant au coût de la carte.
        */
        if(p.getResources() >= c.getCost())
            p.setResources(p.getResources()-c.getCost());
        /*  à la fin de cette phase, le joueur actif perd les ressources
            qu'il lui reste.
        */
        p.setResources(0);
    }
    
}
