package FlightChess.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InformationBoard extends JPanel {
    private Vector<String>  messages;
    private JList<String> list;
    private JLabel curPlayer;

    public InformationBoard(){
        super();
        this.setLayout(new BorderLayout());
        messages = new Vector<String>();
        list = new JList<String>();
        JScrollPane scroll = new JScrollPane(list);
        list.setVisibleRowCount(7);
        scroll.setPreferredSize(new Dimension(230,150));
        this.add(scroll,BorderLayout.SOUTH);

        curPlayer = new JLabel("Now is player  turn");
        curPlayer.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        this.add(curPlayer,BorderLayout.NORTH);

        this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
    }

    /**
     * Add message to be show in application
     * @param message message to show in application
     */
    public void AddMessage(String message) {
        messages.add(message);
        updateData();
    }

    public void updateData(){
        list.setListData(messages);
    }

    /**
     * show current player message
     * @param info current player info to display in application
     */
    public void switchPlayer(String info){
        curPlayer.setText(info);
    }
}