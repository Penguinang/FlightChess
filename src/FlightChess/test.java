package FlightChess;

import java.awt.Dimension;

import javax.swing.JFrame;

import FlightChess.Controller.MainController;
import FlightChess.Model.Game;
import FlightChess.View.MainView;

public class test{
    /** Application Entry */
    public static void main(String[] args){
         JFrame frame = new JFrame("Aeroplane Chess");
         frame.setMinimumSize(new Dimension(500,600));
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         MainView mainView = new MainView();
         frame.setContentPane(mainView);
         frame.setVisible(true);

         Game game = new Game();

         MainController mainController = new MainController(game,mainView);
    }
}
