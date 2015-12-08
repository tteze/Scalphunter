/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JWindow;
import modele.Board;
import modele.Minion;

/**
 *
 * @author Théophile
 */
public class VueBoard extends JComponent implements MouseListener, MouseMotionListener {

    private Board board;
    private VueMinion[][] minions;
    private Control c;
    private int longueur;
    private int largeur;
    JWindow f;

    public VueBoard(Board board, int longueur, int largeur, Control c) throws IOException {
        this.board = board;
        this.longueur = longueur;
        this.largeur = largeur;
        this.minions = new VueMinion[this.board.getX()][this.board.getState()];
        this.c = c;
        this.f = null;
        addMouseListener((MouseListener) this);
        addMouseMotionListener(this);
    }

    public Control getC() {
        return c;
    }

    @Override
    public void paintComponent(Graphics p1) {
        Graphics2D p = (Graphics2D) p1;
        for (int i = 0; i < this.board.getX(); i++) {
            for (int u = 0; u < this.board.getState(); u++) {
                if (this.board.getBoard(i, u) == null) {
                    minions[i][u] = null;
                } else {
                    if (this.board.getBoard(i, u).getClass() == Minion.class) {
                        minions[i][u] = new VueMinion((Minion) this.board.getBoard(i, u), this.longueur / this.board.getX(), this.largeur / this.board.getState());
                    }
                }
            }
        }
        for (int i = 0; i < this.minions.length; i++) {
            for (int u = 0; u < this.minions[i].length; u++) {
                if (this.minions[i][u] == null) {
                    p.setColor(Color.gray);
                    p.fillRect(i * this.longueur / this.board.getX(), u * this.largeur / this.board.getState(), this.longueur / this.board.getX(), this.largeur / this.board.getState());
                } else {
                    this.minions[i][u].paint(p, i * this.longueur / this.board.getX(), u * this.largeur / this.board.getState());
                }
                p.setColor(Color.black);
                p.drawRect(i * this.longueur / this.board.getX(), u * this.largeur / this.board.getState(), this.longueur / this.board.getX(), this.largeur / this.board.getState());
            }
        }
        //p.setColor(Color.black);
        //p.drawLine(this.longueur-1, 0, this.longueur-1, this.largeur);
        //p.drawLine(0, this.largeur-1, this.longueur, this.largeur-1);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.longueur, this.largeur);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < this.minions.length; i++) {
            if (e.getX() >= i * this.longueur / this.board.getX() && e.getX() < (i + 1) * this.longueur / this.board.getX()) {
                for (int u = 0; u < this.minions[i].length; u++) {
                    if (e.getY() >= u * this.largeur / this.board.getState() && e.getY() < (u + 1) * this.largeur / this.board.getState()) {
                        if (this.board.getBoard(i, u) != null) {
                            c.card_clicked(this.board.getBoard(i, u));
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (f != null) {
            f.setVisible(false);
            f.dispose();
        }
        for (int i = 0; i < this.minions.length; i++) {
            if (e.getX() >= i * this.longueur / this.board.getX() && e.getX() < (i + 1) * this.longueur / this.board.getX()) {
                for (int u = 0; u < this.minions[i].length; u++) {
                    if (e.getY() >= u * this.largeur / this.board.getState() && e.getY() < (u + 1) * this.largeur / this.board.getState()) {
                        if (this.board.getBoard(i, u) != null) {
                            try {
                                this.f = new JWindow();
                                f.setPreferredSize(new Dimension(150, 200));
                                JLabel label = new JLabel(new ImageIcon(this.board.getBoard(i, u).getImage()));
                                f.add(label);
                                f.pack();
                                f.setLocation(new Point(e.getX()+25, e.getY()+25));
                                f.validate();
                                f.setVisible(true);
                            } catch (Exception error) {

                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
