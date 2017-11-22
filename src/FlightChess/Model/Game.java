package FlightChess.Model;

import java.util.Random;

import FlightChess.View.GameView;

public class Game {
	private Boat[] boats;
	private int current_boat;
	private GameView gameV;
	/** 随机数产生器 */
	private Random dice_generator;
	/**终点坐标*/
	public static final int final_grid = 35; 
	/**道具1坐标 多走一轮*/
	public static final int[] prop1_grid = {1,2,3};
	/**道具2坐标 后退五步*/
	public static final int[] prop2_grid = {4,5,6};
	/**道具3坐标 暂停一轮*/
	public static final int[] prop3_grid = {7,8,9};
	/**道具4坐标 前进五步*/
	public static final int[] prop4_grid = {10,11,12};
	/**道具5坐标 

	
	
	
	
	
	/**
	 * 产生一个1-6之间的随机整数（模拟骰子的功能）。
	 * @return 1-6之间的随机整数
	 */
	public int onClickDice(){
		return dice_generator.nextInt(5)+1;
	}
	
	public Boat getCurrentBoat() {
		return this.boats[this.current_boat];
	}
	
	public void checkCurrentGrid() {
		//到达终点
		
		int i;
		for(i=0;i<prop1_grid.length;i++) {
			if(this.getCurrentBoat().getCurrent_pos()==prop1_grid[i]) {
			}
		}
		
	}
	
	public int checkWinner() {
		for(int i=0;i<this.boats.length;i++) {
			if(this.boats[i].getCurrent_pos()==final_grid) {
				return i;
			}
		}
		return -1;
	}
	
}


