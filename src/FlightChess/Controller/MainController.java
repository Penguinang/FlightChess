package FlightChess.Controller;

import FlightChess.View.MainView;
import FlightChess.View.StartButtonObserver;

public class MainController implements StartButtonObserver{
    MainView mainView;

    public MainController(MainView mainView){
        this.mainView = mainView;
        mainView.AddStartObserver(this);
    }

    @Override
    public void OnGameStarted(){
        mainView.StartGame();
    }

}