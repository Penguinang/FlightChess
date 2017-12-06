package FlightChess.View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class GamePanel extends JPanel{
    private Image bkg;
    /** panel's size */
    private int width;
    private int height;

    public GamePanel(String bkgPath){
        ImageIcon bkgIcon = new ImageIcon(bkgPath);
        bkg = bkgIcon.getImage();
        width = bkgIcon.getIconWidth()/2;
        height = bkgIcon.getIconHeight()/2;
        this.setSize(width,height);
    }

    /**
     * Override draw function to draw bkg
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(bkg,0,0,width,height,this);
    }
     
    @Override 
    public Dimension getPreferredSize(){
        return new Dimension(width,height);
    }
}