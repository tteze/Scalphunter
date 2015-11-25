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

    @Override
    public void action(Player p) {
        /*  au debut de cette phase, le joueur actif gagne x ressources
            ou x est le tour de jeu en cours.
        */
        /*  le joueur actif peut depenser des ressources pour jouer une
            carte de sa main. Cette carte passe de la ligne main à la ligne
            terrain.
        */
        /*  si il a au moins autant de ressources que le coût de la carte,
            il perd le nombre de ressources correspondant au coût de la carte.
        */
        /*  à la fin de cette phase, le joueur actif perd les ressources
            qu'il lui reste.
        */
    }
    
}
