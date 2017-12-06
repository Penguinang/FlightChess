package FlightChess.Controller;

import FlightChess.Model.Game;
import FlightChess.View.MainView;
import FlightChess.View.StartButtonObserver;

public class MainController implements StartButtonObserver{
    private MainView mainView;
    private Game game;
    private GameController gameController;


    public MainController(Game game,MainView mainView){
        this.mainView = mainView;
        this.game = game;
        mainView.AddStartObserver(this);
    }

    @Override
    public void OnGameStarted(){
        //XXX
        mainView.StartGame();

        gameController = new GameController(mainView.getGameView());

        // game.start
    }

}