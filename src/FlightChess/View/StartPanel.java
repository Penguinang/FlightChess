package FlightChess.View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
    private Image bkg;
    
    /**
     * @param bkgPath background image's path
     */
    public StartPanel(String bkgPath){
        super();
        bkg = new ImageIcon(bkgPath).getImage();
        setPreferredSize(new Dimension(500,600));
    }

    /**
     * Override paint to draw image
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(bkg,0,0,500,600,this);
    }
}