package FlightChess.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainView extends JPanel {
    /** Game Panel */
    private GameView gameView;
    /** Start Game Panel */
    private StartPanel startView;
    /** Observers List */
    private ArrayList<StartButtonObserver> startObservers;

    /** Constructor */
    public MainView() {
        startObservers = new ArrayList<StartButtonObserver>();

        startView = new StartPanel("res/view/start.png");
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(StartButtonObserver observer : startObservers)
                    observer.OnGameStarted();
            }
        });
        startView.add(startButton);

        this.add(startView);
    }

    /**
     * Start Game,change to game view and init gameview
     * @return gameView game view reference
     */
    public GameView StartGame() {
        startView.setVisible(false);
        this.remove(startView);

        gameView = new GameView();
        this.add(gameView);

        gameView.InitGameView();
        gameView.ShowGame();

        return gameView;
    }

    /**
     * add observer for startbutton,observer will be informed,and observer must implents interface StartButtonObserver
     * @param observer the observer that will be informed
     * @return whether success
     */
    public boolean AddStartObserver(StartButtonObserver observer) {
        startObservers.add(observer);
        return true;
    }


    //=======================getters and setters==========================
    public GameView getGameView(){
        return gameView;
    }
}