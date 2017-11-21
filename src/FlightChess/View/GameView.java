package FlightChess.View;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GameView extends JPanel{
    public GameView(){
        this.setMinimumSize(new Dimension(500,500));
        JTextArea test = new JTextArea("开始游戏StartGame");
        test.setFont(new Font("宋体",Font.PLAIN,24));
        this.add(test);
        this.setVisible(false);
    }

    /**
     * Init game view
     */
    public void InitGameView(){
        this.add(new JButton("init success"));
    }

    /**
     * Show Game View.after gameView have  inited successfully
     */
    public void ShowGame(){
        this.setVisible(true);
    }
}