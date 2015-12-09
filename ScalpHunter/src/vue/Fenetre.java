/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.sun.awt.AWTUtilities;
import controleur.Control;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Game;
import modele.Player;
import modele.PlayerHuman;

/**
 *
 * @author Théophile
 */
public class Fenetre extends JFrame implements ActionListener {

    private VueBoard v;
    private Game g;
    private Control c;
    private JLabel player1, player2;
    private JLabel health1, health2;
    private JLabel ress1, ress2;
    private JButton next;

    public Fenetre(Game g) throws IOException {
        this.g = g;
        this.c = new Control(this);
        this.g.setC(this.c);
        this.v = new VueBoard(g.getBoardGame(), 900, 600, this.c);
        if (g.getPlayer1().getClass() == PlayerHuman.class) {
            ((PlayerHuman) g.getPlayer1()).setC(this.getC());
        }
        if (g.getPlayer2().getClass() == PlayerHuman.class) {
            ((PlayerHuman) g.getPlayer2()).setC(this.getC());
        }
        this.initialisation();
    }

    public VueBoard getV() {
        return v;
    }

    public Control getC() {
        return c;
    }

    public Game getG() {
        return g;
    }

    public void initialisation() {
        this.player1 = new JLabel("Player " + this.getG().getPlayer1().getId());
        this.health1 = new JLabel("" + this.getG().getPlayer1().getHealth() + " PV");
        this.ress1 = new JLabel("Ressources: " + this.getG().getPlayer1().getResources());
        this.player2 = new JLabel("Player " + this.getG().getPlayer2().getId());
        this.health2 = new JLabel("" + this.getG().getPlayer2().getHealth() + " PV");
        this.ress2 = new JLabel("Ressources: " + this.getG().getPlayer2().getResources());
        this.next = new JButton("      Begin       ");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 9;
        c.weighty = 9;
        c.insets = new Insets(4, 4, 4, 4);

        next.addActionListener(this);

        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(this.player1, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(this.health1, c);
        c.gridx = 2;
        c.gridy = 0;
        panel.add(this.ress1, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 6;
        c.gridheight = 7;
        panel.add(this.v, c);
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 8;
        panel.add(this.player2, c);
        c.gridx = 1;
        c.gridy = 8;
        panel.add(this.health2, c);
        c.gridx = 2;
        c.gridy = 8;
        panel.add(this.ress2, c);
        c.gridx = 8;
        c.gridy = 7;
        next.setPreferredSize(new Dimension(150, 40));
        panel.add(this.next, c);
        add(panel);
        this.setTitle("ScalpHunter");
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    public void update() {
        health1.setText("" + this.getG().getPlayer1().getHealth() + " PV");
        ress1.setText("Ressources: " + this.getG().getPlayer1().getResources());
        health2.setText("" + this.getG().getPlayer2().getHealth() + " PV");
        ress2.setText("Ressources: " + this.getG().getPlayer2().getResources());
        switch (c.getRound()) {
            case 0:
                next.setText("Player " + this.g.getPlayer().getId() + " Defense");
                break;
            case 1:
                next.setText("Player " + this.g.getPlayer().getId() + " Sommon");
                break;
            case 2:
                next.setText("Player " + this.g.getPlayer().getId() + " Attack");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            c.continuef_clicked();
        }
    }
}
