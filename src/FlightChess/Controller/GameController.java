package FlightChess.Controller;

import FlightChess.View.DiceClickObserver;
import FlightChess.View.GameView;

public class GameController implements DiceClickObserver{
    private GameView gameView;

    public GameController(GameView gameView){ 
        this.gameView = gameView;
        gameView.AddDiceObserver(this);
    }

    @Override
    public void OnDiceClicked(){
        //XXX
        gameView.PlayDiceAnimation(3);
    }
}