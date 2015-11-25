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
    private Game current;

    // constructeur
    public Move(Game current) {
        this.current = current;
    }

    // getters et setters
    public Game getCurrent() {
        return current;
    }

    public void setCurrent(Game current) {
        this.current = current;
    }
    
    // fonctions
    public abstract void action(Card c, Player p); // TODO modifier le diagramme de classe (ajout parametre p)
    
}
