package FlightChess.View;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class GamePanel extends JPanel {
    private Image bkg;
    /** panel's size */
    private int mapWidth;
    private int mapHeight;

    private Image[] boats;
    private int[] boatPositions;
    private int boatWidth;
    private int boatHeight;

    /** boat move animation */
    private ScheduledExecutorService scheduler;
    /** timeunit ms */
    private int boatMoveInterval = 500;

    private Dimension[] points = { new Dimension(270, 113), new Dimension(389, 113), new Dimension(506, 113),
            new Dimension(624, 113), new Dimension(754, 113), new Dimension(887, 113), new Dimension(887, 186),
            new Dimension(887, 241), new Dimension(793, 280), new Dimension(700, 316), new Dimension(700, 391),
            new Dimension(702, 465), new Dimension(795, 510), new Dimension(882, 546), new Dimension(882, 615),
            new Dimension(840, 672), new Dimension(735, 675), new Dimension(623, 675), new Dimension(509, 672),
            new Dimension(435, 612), new Dimension(436, 533), new Dimension(424, 451), new Dimension(303, 450),
            new Dimension(258, 525), new Dimension(248, 598), new Dimension(224, 671), new Dimension(113, 675),
            new Dimension(70, 600), new Dimension(70, 550), new Dimension(70, 491), new Dimension(70, 412),
            new Dimension(70, 340), new Dimension(70, 260), new Dimension(160, 217), new Dimension(259, 185) };
    
    /**
     * Constructor 
     * @param bkgPath
     */
    public GamePanel(String bkgPath) {
        //bkg
        ImageIcon bkgIcon = new ImageIcon(bkgPath);
        bkg = bkgIcon.getImage();
        mapWidth = bkgIcon.getIconWidth() / 2;
        mapHeight = bkgIcon.getIconHeight() / 2;
        //boats
        boats = new Image[3];
        boats[0] = new ImageIcon("res/view/green.png").getImage();
        boats[1] = new ImageIcon("res/view/orange.png").getImage();
        boats[2] = new ImageIcon("res/view/yellow.png").getImage();
        boatPositions = new int[3];
        boatWidth = 60;
        boatHeight = 40;

        scheduler = Executors.newScheduledThreadPool(1);
    }

    /**
     * Init Game Panel
     */
    public void init() {
        boatPositions[0] = 0;
        boatPositions[1] = 0;
        boatPositions[2] = 0;
    }

    /** 
     * Move Boat
     * @param index index of boat
     * @param step steps number
     */
    public void moveBoat(int index, int step) {
        if (index < 0 || index > 3) {
            System.out.println("wrong boat index ");
            return;
        }

        Runnable updatePosition = new Runnable() {
            int curStep = 0;
            @Override
            public void run() {
                while(curStep<Math.abs(step)){
                    try{
                        Thread.sleep(boatMoveInterval);
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    System.out.println("update position");
                    boatPositions[index] += step / Math.abs(step);
                    if (boatPositions[index] < 0)
                        boatPositions[index] = 0;
                    if (boatPositions[index] > points.length - 1)
                        boatPositions[index] = points.length - 1;
    
                    updateUI();
                    curStep ++;
                }
            }
        };

        scheduler.schedule(updatePosition, 0, TimeUnit.MILLISECONDS);
    }

    /** Override draw function to draw bkg */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bkg, 0, 0, mapWidth, mapHeight, this);
        for (int i = 0; i < 3; i++) {
            int grid = boatPositions[i];
            int x = (points[grid].width + 25) / 2;
            int y = points[grid].height / 2;
            g.drawImage(boats[i], x - boatWidth / 2, y - boatHeight, boatWidth, boatHeight, this);
        }
    }

    /** Override size */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(mapWidth, mapHeight);
    }
}