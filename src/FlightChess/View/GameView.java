package FlightChess.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import FlightChess.View.DiceClickObserver;

@SuppressWarnings("serial")
public class GameView extends JPanel{
    private ArrayList<DiceClickObserver> diceObservers;
    public GameView(){
        diceObservers = new ArrayList<DiceClickObserver>();

        this.setLayout(new GridBagLayout());
        GridBagConstraints position = new GridBagConstraints();

        this.setMinimumSize(new Dimension(500,500));
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
        
        position.gridx = 2;
        position.gridy = 2;
        position.weightx = 1;
        this.add(dice,position);
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
    }
}