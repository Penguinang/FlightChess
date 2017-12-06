package FlightChess.View;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class WinnerDialog extends JDialog{

    public WinnerDialog(){
        super();
        this.setBounds(400, 300, 300, 100);
    }

    public void showWinnerMessage(String playerMessage){
        JLabel content = new JLabel(playerMessage);
        this.setContentPane(content);
    }
}