package FlightChess.Model;

import java.util.Random;

import FlightChess.View.GameView;
import FlightChess.View.MainView;

/** 
 * FlightChess 
 * The main class of games, mainly including the information of the ship and the location of the game
 */
public class Game {
    /** array of boat */
    private Boat[] boats;
    /** random number generator */
    private Random dice_generator;

    /** the state of game */
    private boolean game_state = true;
    /** The current activated boat */
	private int current_boat;
	
	

	/** Terminal coordinates */
	public static final int FINAL_GRID = 34; 
	/** The coordinates of the props moving forward */
	public static final int[] PROP1_GRID = {3,8,19,33};
	/** The coordinates of the props moving back */
	public static final int[] PROP2_GRID = {7,14,25};
	/** The coordinates of the props a round of prohibition */
	public static final int[] PROP3_GRID = {22,31};
	/** The coordinates of the props taking one more round */
	public static final int[] PROP4_GRID = {13,29};
	/** The forward step of prop1 */
	public static final int FOWARD_STEP = 5;
	/** The back step of prop2 */
	public static final int BACK_STEP = -5;
	
	
	public Game() {
		super();
		Boat b1 = new Boat(0,0,"green");
		Boat b2 = new Boat(1,0,"orange");
		Boat b3 = new Boat(2,0,"yellow");
		this.boats = new Boat[3];
		boats[0] = b1;
		boats[1] = b2;
		boats[2] = b3;
		
		this.dice_generator = new Random();
		this.current_boat = 0;
	}
	
	/** start the game */
	public void startGame(MainView mv) {
		mv.StartGame();
	}

	/**
	 * Produce a random integer between 1-6 (the function of the dice) and let the ship move forward
	 * @return a random integer between 1-6
	 */
	public int onClickDice(GameView gv){
		int dice = dice_generator.nextInt(5)+1;
		gv.PlayDiceAnimation(dice);
		this.getCurrentBoat().advance(dice,gv);
		gv.printMessage(this.getCurrentBoat().getColor()+"向前"+dice+"步"+"到达第"+this.getCurrentBoat().getCurrent_pos()+"格");
		this.checkCurrentGrid(gv);
		this.checkWinner(gv);
		this.switchPlayer();
		gv.switchPlayer("轮到"+this.getCurrentBoat().getColor()+"行驶");
		return dice;
	}
	
	/**
	 * Get the object of the current activated ship
	 * @return the object of the current activated ship
	 */
	public Boat getCurrentBoat() {
		return this.boats[this.current_boat];
	}
	
	/** Check whether the ship's current position has a prop and make a respond */
	public void checkCurrentGrid(GameView gv) {
		int i;
		for(i = 0;i<PROP1_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP1_GRID[i]) {
				this.boats[this.current_boat].advance(FOWARD_STEP,gv);
				gv.printMessage(this.getCurrentBoat().getColor()+"到达灯塔,多走5格"+"到达第"+this.getCurrentBoat().getCurrent_pos()+"格");
			}
		}
		for(i=0;i<PROP2_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP2_GRID[i]) {
				this.boats[this.current_boat].advance(BACK_STEP,gv);
				gv.printMessage(this.getCurrentBoat().getColor()+"捡到游泳圈,后退5格"+"到达第"+this.getCurrentBoat().getCurrent_pos()+"格");
				
			}
		}
		for(i=0;i<PROP3_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP3_GRID[i]) {
				this.boats[this.current_boat].setGrounded(true);
				gv.printMessage(this.getCurrentBoat().getColor()+"抛锚,暂停一轮");
			}
		}
		for(i=0;i<PROP4_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP4_GRID[i]) {
				gv.printMessage(this.getCurrentBoat().getColor()+"捡到方向盘,再走一次");
				this.setCurrent_boat( (this.current_boat+2)%this.boats.length);
			}
		}
		
	}
	
	/** Update the current player on the basis of the previous step */
	public void switchPlayer() {
		int c = (this.current_boat+1)%this.boats.length;
		if(this.boats[c].isGrounded()==true) {
			this.current_boat = (this.current_boat+2)%this.boats.length;
			this.boats[c].setGrounded(false);
		}
		else this.current_boat = c;
	}

	/**
	 * check the winner
	 * @return the ID of the winner
	 */
	public int checkWinner(GameView gv) {
		for(int i=0;i<this.boats.length;i++) {
			if(this.boats[i].getCurrent_pos()==FINAL_GRID) {
				gv.printMessage(this.getBoats()[i].getColor()+"获胜");
				this.game_state = false;
				gv.gameEnd(this.getBoats()[i].getColor()+"获胜!");
				return i;
			}
		}
		return -1;
	}
	
	/** output current state on console */
//    public void showCurrentState(GameView gv){
//		for(Boat s : this.boats){
//			String res;
//			res = "The "+s.getId()+" boat is at"+s.getCurrent_pos();
//			gv.printMessage(res);
//		}
//	}
     
   
    public int getCurrent_boat() {
        return current_boat;
    }

    public Boat[] getBoats() {
        return boats;
    }

    public void setBoats(Boat[] boats) {
        this.boats = boats;
    }

    public Random getDice_generator() {
        return dice_generator;
    }

    public void setDice_generator(Random dice_generator) {
        this.dice_generator = dice_generator;
    }

    public boolean isGame_state() {
        return game_state;
    }

    public void setGame_state(boolean game_state) {
        this.game_state = game_state;
    }

    public static int getFinalGrid() {
        return FINAL_GRID;
    }

    public static int[] getProp1Grid() {
        return PROP1_GRID;
    }

    public static int[] getProp2Grid() {
        return PROP2_GRID;
    }

    public static int[] getProp3Grid() {
        return PROP3_GRID;
    }

    public static int[] getProp4Grid() {
        return PROP4_GRID;
    }

    public static int getFowardStep() {
        return FOWARD_STEP;
    }

    public static int getBackStep() {
        return BACK_STEP;
    }

    public void setCurrent_boat(int current_boat) {
        this.current_boat = current_boat;
    }

}
