/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import modele.Card;
import modele.Minion;
import vue.Fenetre;
import vue.VueBoard;

/**
 *
 * @author Théophile
 */
public class Control {
    private Fenetre f;
    private ArrayList<Card> cards,cards2;
    private boolean continuef;
    private int round;
    
    public Control(Fenetre f){
        this.f=f;
        continuef=false;
        round=0;
        this.cards=new ArrayList();
        this.cards2=new ArrayList();
    }
    
    private boolean isCardOfCP(Card c){
        for(int i=0;i<this.f.getG().getCurrent_player().getDeck().size();i++)
            if(this.f.getG().getCurrent_player().getDeck().get(i)==c)
                return true;
        return false;
    }
    
    public void card_clicked(Card c){
        // TODO le switch est la pour futur amélioration surement, on pourra l'enlever si on ne s'en sert pas
        switch(this.round){
            case 0: //defense
                if(this.isCardOfCP(c)){
                    if(c.getClass()==Minion.class){
                        if(!((Minion)c).isTired() && !((Minion)c).isSommon()){
                            if(c.isSelected()){
                                this.cards.remove(c);
                                c.setSelected(false);
                                this.update();
                            }else{
                                this.cards.add(c);
                                c.setSelected(true);
                                this.update();
                            }
                        }
                    }
                }
                else{
                    if(c.getClass()==Minion.class){
                        if(!((Minion)c).isTired() && !((Minion)c).isSommon()){
                            if(c.isSelected()){
                                this.cards2.remove(c);
                                c.setSelected(false);
                                this.update();
                            }else{
                                this.cards2.add(c);
                                c.setSelected(true);
                                this.update();
                            }
                        }
                    }
                }
                    
                break;
            case 1: //attack
                if(this.isCardOfCP(c)){
                    if(c.getClass()==Minion.class){
                        if(!((Minion)c).isTired() && !((Minion)c).isSommon()){
                            if(c.isSelected()){
                                this.cards.remove(c);
                                c.setSelected(false);
                                this.update();
                            }else{
                                this.cards.add(c);
                                c.setSelected(true);
                                this.update();
                                
                            }
                        }
                    }
                }
                break;
            case 2: // sommon
                if(this.isCardOfCP(c)){
                    if(c.getClass()==Minion.class){
                        if(!((Minion)c).isTired() && !((Minion)c).isSommon()){
                            if(c.isSelected()){
                                this.cards.remove(c);
                                c.setSelected(false);
                                this.update();
                            }else{
                                this.cards.add(c);
                                c.setSelected(true);
                                this.update();
                            }
                        }
                    }
                }
                break;
        }
    }
    
    public void continuef_clicked(){
        this.continuef=true;
    }
    
    public boolean  get_continuef(){
        if(continuef){
            continuef=false;
            return true;
        }
        return false;
    }
    
    public ArrayList<Card> get_cards(){
        return this.cards;
    }
    
    public ArrayList<Card> get_cards2(){
        return this.cards;
    }
    
    public void nextround(){
        this.cards.clear();
        this.cards2.clear();
        for(int i=0;i<this.f.getG().getPlayer1().getDeck().size();i++)
            this.f.getG().getPlayer1().getDeck().get(i).setSelected(false);
        for(int i=0;i<this.f.getG().getPlayer2().getDeck().size();i++)
            this.f.getG().getPlayer2().getDeck().get(i).setSelected(false);
        this.round++;
        round%=3;
    }
    
    public void update(){
        //TODO mise à jour des labels de fenetre 
        this.f.getV().repaint();
    }
}
