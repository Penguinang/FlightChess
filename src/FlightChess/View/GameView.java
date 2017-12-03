package FlightChess.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import FlightChess.View.DiceClickObserver;

@SuppressWarnings("serial")
public class GameView extends JPanel{
    private ArrayList<DiceClickObserver> diceObservers;
    public GameView(){
        diceObservers = new ArrayList<DiceClickObserver>();

        this.setLayout(new BorderLayout());

        /** Game Panel */
        JPanel gamePanel = new JPanel();
        gamePanel.add(new TextArea("asjdijalksdjlad\n\nasfdad"));
        this.add(gamePanel,BorderLayout.NORTH);

        /** Information Panel */
        JPanel infoPanel = new JPanel();
        JButton dice = new JButton(new ImageIcon("res/view/dice.png"));
        dice.setBackground(new Color(0,0,0,0));
        dice.setBorder(null);
        dice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(DiceClickObserver observer : diceObservers){
                    observer.OnDiceClicked();
                }
            }
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
        System.out.println("play dice animation "+number);
        // ImageComponent giftest = new ImageComponent("res/view/1.gif");
        Icon giftest = new ImageIcon("res/view/1.gif");
        JLabel test = new JLabel(giftest);
        GridBagConstraints position = new GridBagConstraints();
        position.gridx = 0;
        position.gridy = 0;
        this.add(new JButton("button"),BorderLayout.EAST);
        this.updateUI();
        // this.add(test,position);

    }
}