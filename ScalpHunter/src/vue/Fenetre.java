/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Fenetre extends JFrame implements ActionListener{
    private VueBoard v;
    private Game g;
    private Control c;
    private JLabel player1,player2;
    private JLabel health1,health2;
    private JLabel ress1 ,ress2;
    private JButton next;
    
    public Fenetre(Game g){
        this.g=g;
        this.c=new Control(this);
        this.g.setC(this.c);
        this.v=new VueBoard(g.getBoardGame(),600,600,this.c);
        if(g.getPlayer1().getClass()==PlayerHuman.class){
            ((PlayerHuman)g.getPlayer1()).setC(this.getC());
        }
        if(g.getPlayer2().getClass()==PlayerHuman.class){
            ((PlayerHuman)g.getPlayer2()).setC(this.getC());
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
    
    
    
    
    public void initialisation(){
       this.player1=new JLabel("Joueur "+this.getG().getPlayer1().getId());
       this.health1=new JLabel(""+this.getG().getPlayer1().getHealth()+" PV");
       this.ress1=new JLabel("Ressources: "+this.getG().getPlayer1().getResources());
       this.player2=new JLabel("Joueur "+this.getG().getPlayer2().getId());
       this.health2=new JLabel(""+this.getG().getPlayer2().getHealth()+" PV");
       this.ress2=new JLabel("Ressources: "+this.getG().getPlayer2().getResources());
       this.next=new JButton("Round "+c.getRound()+" pour joueur"+g.getPlayer().getId());
       
       next.addActionListener(this);
       JPanel panel=new JPanel();
       panel.add(this.player1);
       panel.add(this.health1);
       panel.add(this.ress1);
       panel.add(this.v);
       panel.add(this.player2);
       panel.add(this.health2);
       panel.add(this.ress2);
       panel.add(this.next);
       this.add(panel);
       this.setTitle("ScalpHunter");
       this.pack();
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setLocationRelativeTo(null);
    }
    
    public void update(){
        player1.setText("Joueur "+this.getG().getPlayer1().getId());
        health1.setText(""+this.getG().getPlayer1().getHealth()+" PV");
        ress1.setText("Ressources: "+this.getG().getPlayer1().getResources());
        player2.setText("Joueur "+this.getG().getPlayer2().getId());
        health2.setText(""+this.getG().getPlayer2().getHealth()+" PV");
        ress2.setText("Ressources: "+this.getG().getPlayer2().getResources());
        next.setText("Round "+c.getRound()+" pour joueur"+g.getPlayer().getId());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
           c.continuef_clicked();
        }
    }
}
