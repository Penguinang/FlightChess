package FlightChess.View;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InformationBoard extends JPanel {
    private Vector<String>  messages;
    private JList<String> list;

    public InformationBoard(){
        super();
        messages = new Vector<String>();
        list = new JList<String>();
        JScrollPane scroll = new JScrollPane(list);
        list.setVisibleRowCount(3);
        scroll.setPreferredSize(new Dimension(230,50));
        this.add(scroll);
    }

    public void AddMessage(String message) {
        messages.add(message);
        updateData();
    }

    public void updateData(){
        list.setListData(messages);
    }
}