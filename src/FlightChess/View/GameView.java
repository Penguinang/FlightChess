package FlightChess.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FlightChess.View.DiceClickObserver;

@SuppressWarnings("serial")
public class GameView extends JPanel{
    private ArrayList<DiceClickObserver> diceObservers;
    private JPanel gamePanel;
    private JPanel infoPanel;
    private JLabel dice;

    public GameView(){
        diceObservers = new ArrayList<DiceClickObserver>();

        this.setLayout(new BorderLayout());

        /** Game Panel */
        gamePanel = new GamePanel("res/view/bkg.jpg");
        this.add(gamePanel,BorderLayout.NORTH);

        /** Information Panel */
        infoPanel = new JPanel();
        dice = new JLabel(new ImageIcon("res/view/dice.png"));
        dice.addMouseListener(new MouseListener(){
            @Override
            public void mouseReleased(MouseEvent e) {
                for(DiceClickObserver observer : diceObservers){
                    observer.OnDiceClicked();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });
        infoPanel.add(dice);    
        this.add(infoPanel,BorderLayout.SOUTH);   
    }

    /**
     * Init game view
     */
    public void InitGameView(){
    }

    /**
     * Show Game View.after gameView have  inited successfully
     */
    public void ShowGame(){
        this.setVisible(true);
    }

    /**
     * Add Dice Observer
     * @param observer observer to add
     */
    public boolean AddDiceObserver(DiceClickObserver observer){
        diceObservers.add(observer);
        return true;
    }

    /**
     * Play Dice Animation
     * @param number the dice number to play
     */
    public void PlayDiceAnimation(int number){
        //XXX
        infoPanel.remove(dice);
        
        Random randomint = new Random();
        Icon giftest = new ImageIcon("res/view/"+number+".gif");
        dice = new JLabel(giftest);
        infoPanel.add(dice);
        System.out.println("play animation");
        dice.addMouseListener(new MouseListener(){        
            @Override
            public void mouseReleased(MouseEvent e) {
                for(DiceClickObserver observer : diceObservers){
                    observer.OnDiceClicked();
                    System.out.println("click");
                }                
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
        });

        this.updateUI();
    }
}