package FlightChess.Controller;

import FlightChess.Model.Game;
import FlightChess.View.DiceClickObserver;
import FlightChess.View.GameView;

public class GameController implements DiceClickObserver{
    private GameView gameView;
    private Game game;

    public GameController(Game game,GameView gameView){ 
        this.gameView = gameView;
        this.game = game;
        gameView.AddDiceObserver(this);
    }

    @Override
    public void OnDiceClicked(){
        game.onClickDice(gameView);
    }
}