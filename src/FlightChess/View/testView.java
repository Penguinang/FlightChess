package FlightChess.View;

import java.awt.Dimension;

import javax.swing.JFrame;

public class testView implements StartButtonObserver{
    private MainView mainView;
    public void main(String[] args){
        System.out.println("Hello World");
        
        JFrame frame = new JFrame("Aeroplane Chess");
        frame.setMinimumSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainView = new MainView();
        frame.setContentPane(mainView);
        frame.setVisible(true);

        mainView.AddStartObserver(this);
    }

    @Override
    public void OnGameStarted(){
        // MainController -> Game -> mainView
        mainView.StartGame();
    };
}