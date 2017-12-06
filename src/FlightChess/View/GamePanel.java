package FlightChess.View;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

class GamePanel extends JPanel{
    private Image bkg;
    /** panel's size */
    private int mapWidth;
    private int mapHeight;

    private Image[] boats;
    private int[] boatPositions;
    private int boatWidth;
    private int boatHeight;
    private Dimension[] points  = {
        new Dimension(100,260),
        new Dimension(86,340),
        new Dimension(94,412),
        new Dimension(76,530),
        new Dimension(76,600),
        new Dimension(123,662),
        new Dimension(239,668),
        new Dimension(254,588)
    };

    public GamePanel(String bkgPath){
        //bkg
        ImageIcon bkgIcon = new ImageIcon(bkgPath);
        bkg = bkgIcon.getImage();
        mapWidth = bkgIcon.getIconWidth()/2;
        mapHeight = bkgIcon.getIconHeight()/2;
        //boats
        boats = new Image[3];
        boats[0] = new ImageIcon("res/view/green.png").getImage();
        boats[1] = new ImageIcon("res/view/orange.png").getImage();
        boats[2] = new ImageIcon("res/view/yellow.png").getImage();        
        boatPositions = new int[3];
        boatWidth = 50;
        boatHeight = 50;
    }

    /**
     * Init Game Panel
     */
    public void init(){
        boatPositions[0] = 0;
        boatPositions[1] = 1;
        boatPositions[2] = 2;
    }
    
    /** 
     * Move Boat
     * @param index index of boat
     * @param step steps number
     */
    public void moveBoat(int index,int step){
        if(index <0 || index>3){
            System.out.println("wrong boat index ");
            return;
        }
        boatPositions[index] += step;
        if(boatPositions[index] < 0)
        boatPositions[index] = 0;
        if(boatPositions[index] > points.length-1)
        boatPositions[index] = points.length-1;
    }

    /**
     * Override draw function to draw bkg
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(bkg,0,0,mapWidth,mapHeight,this);
        for(int i = 0;i<3;i++){
            int grid = boatPositions[i];
            int x = points[grid].width/2;
            int y = points[grid].height/2;
            g.drawImage(boats[i],x,y,boatWidth,boatHeight,this);
        }
    }
     
    @Override 
    public Dimension getPreferredSize(){
        return new Dimension(mapWidth,mapHeight);
    }
}