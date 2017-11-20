package FlightChess.View;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel{
    public GameView(){
        this.setMinimumSize(new Dimension(500,500));
        JButton button = new JButton("开始游戏StartGame");
        button.setFont(new Font("宋体",Font.PLAIN,24));
        this.add(button);
    }
}