package FlightChess;

import java.awt.Dimension;

import javax.swing.JFrame;

import FlightChess.View.MainView;

public class test{
    public static void main(String[] args){
        /**
         * for view test,if commit please uncomment these and delete below
         */
         System.out.println("Hello World");

         JFrame frame = new JFrame("Aeroplane Chess");
         frame.setMinimumSize(new Dimension(500,500));
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         MainView mainView = new MainView();
         frame.setContentPane(mainView);
         frame.setVisible(true);

        // FlightChess.View.testView t = new FlightChess.View.testView();
        // t.main(args);
    }
}
