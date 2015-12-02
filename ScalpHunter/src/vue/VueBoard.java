/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import modele.Board;
import modele.Minion;

/**
 *
 * @author Théophile
 */
public class VueBoard extends JComponent implements MouseListener{
    Board board;
    VueMinion[][] minions;
    int longueur;
    int largeur;

    public VueBoard(Board board, int longueur, int largeur) {
        this.board = board;
        this.longueur = longueur;
        this.largeur = largeur;
        this.minions= new VueMinion[this.board.getX()][this.board.getState()];
        for(int i=0;i<this.board.getX();i++){
            for(int u=0;u<this.board.getState();u++){
                if(this.board.getBoard(i, u)==null){
                    minions[i][u]=null;
                }else{
                    if(this.board.getBoard(i, u).getClass()==Minion.class){
                        minions[i][u]=new VueMinion((Minion)this.board.getBoard(i, u),this.longueur/this.board.getX(),this.largeur/this.board.getState());
                    }
                }
            }
        }
    }
    
    

    @Override
    public void paintComponent(Graphics p1) {
        Graphics2D p = (Graphics2D) p1;
        for(int i=0;i<this.minions.length;i++){
            for(int u=0;u<this.minions[i].length;u++){
                if(this.minions[i][u]==null){
                    p.setColor(Color.gray);
                    p.fillRect(i*this.longueur/this.board.getX(), u*this.largeur/this.board.getState() ,this.longueur/this.board.getX(),this.largeur/this.board.getState());
                }else{
                    this.minions[i][u].paint(p,i*this.longueur/this.board.getX(), u*this.largeur/this.board.getState());
                }
                 p.setColor(Color.black);
                    p.drawRect(i*this.longueur/this.board.getX(), u*this.largeur/this.board.getState() ,this.longueur/this.board.getX(),this.largeur/this.board.getState());
            }
        }
        /*p.setColor(Color.black);
        for(int i=0;i<this.board.getX()+1;i++){
            p.drawLine(i*this.longueur/this.board.getX(), 0, i*this.longueur/this.board.getX(), this.largeur);
        }
        for(int u=0;u<this.board.getState()+1;u++){
            p.drawLine(0, u*this.largeur/this.board.getState(), this.longueur, u*this.largeur/this.board.getState());
        }*/
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.longueur,this.largeur);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
