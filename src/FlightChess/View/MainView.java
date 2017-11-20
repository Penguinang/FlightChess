package FlightChess.View;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainView extends JPanel{
    /** 游戏面板 */
    GameView gameView;
    /** 构造函数 */
    public MainView(){
        gameView = new GameView();
        this.add(gameView);
    }
}