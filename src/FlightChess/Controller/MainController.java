package FlightChess.Controller;

import FlightChess.View.MainView;
import FlightChess.View.StartButtonObserver;

public class MainController implements StartButtonObserver{
    private MainView mainView;
    private GameController gameController;

    public MainController(MainView mainView){
        this.mainView = mainView;
        mainView.AddStartObserver(this);
    }

    @Override
    public void OnGameStarted(){
        //XXX
        mainView.StartGame();

        gameController = new GameController(mainView.getGameView());
    }

}