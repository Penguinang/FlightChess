package FlightChess.Model;

import java.util.Random;

/** 
 * FlightChess 游戏主要类，主要包含船的信息以及位置判断 
 */

public class Game {
    /** 小船数组 */
    private Boat[] boats;
    /** 随机数产生器 */
    private Random dice_generator;

    /** 游戏是否已结束 */
    private boolean game_state = true;
    /** 当前操作小船的ID */
<<<<<<< HEAD
	private int current_boat;
	
	/** 终点坐标*/
	public static final int FINAL_GRID = 34; 
	/** 道具1坐标 前进*/
	public static final int[] PROP1_GRID = {3,8,19,33};
	/** 道具2坐标 后退*/
	public static final int[] PROP2_GRID = {7,14,25};
	/** 道具3坐标 暂停一轮 */
	public static final int[] PROP3_GRID = {22,31};
	/** 道具4坐标 多走一次 */
	public static final int[] PROP4_GRID = {13,29};
	/** 道具1前进步数 */
	public static final int FOWARD_STEP = 5;
	/** 道具2后退步数 */
	public static final int BACK_STEP = -5;
	
	
	public Game() {
		super();
		Boat b1 = new Boat(0,0);
		Boat b2 = new Boat(1,0);
		Boat b3 = new Boat(2,0);
		this.boats = new Boat[3];
		boats[0] = b1;
		boats[1] = b2;
		boats[2] = b3;
		
		this.dice_generator = new Random();
		this.current_boat = 0;
	}

	/**
	 * 产生一个1-6之间的随机整数（模拟骰子的功能），并让船前进
	 * @return 1-6之间的随机整数
	 */
	public int onClickDice(){
		int dice = dice_generator.nextInt(5)+1;
		this.getCurrentBoat().advance(dice);
		return dice;
	}
	
	/**
	 * 获取当前船的对象
	 * @return 当前船的对象
	 */
	public Boat getCurrentBoat() {
		return this.boats[this.current_boat];
	}
	
	/**
	 * 检查船的当前位置是否有道具并进行响应
	 */
	public void checkCurrentGrid() {
		int i;
		for(i = 0;i<PROP1_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP1_GRID[i]) {
				this.boats[this.current_boat].advance(FOWARD_STEP);
				System.out.println(this.getCurrent_boat()+"吃到道具1,多走5格");
			}
		}
		for(i=0;i<PROP2_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP2_GRID[i]) {
				this.boats[this.current_boat].advance(BACK_STEP);
				System.out.println(this.getCurrent_boat()+"吃到道具2,后退5格");
				
			}
		}
		for(i=0;i<PROP3_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP3_GRID[i]) {
				this.boats[this.current_boat].setGrounded(true);
				System.out.println(this.getCurrent_boat()+"吃到道具3,暂停一轮");
			}
		}
		for(i=0;i<PROP4_GRID.length;i++) {
			if(this.boats[this.current_boat].getCurrent_pos()==PROP4_GRID[i]) {
				System.out.println(this.getCurrent_boat()+"吃到道具4,再走一次");
				this.setCurrent_boat( (this.current_boat+2)%this.boats.length);
			}
		}
		
	}
	
	
	/**
	 * 根据上一步的情况更新当前玩家
	 */
	public void switchPlayer() {
		int c = (this.current_boat+1)%this.boats.length;
		if(this.boats[c].isGrounded()==true) {
			this.current_boat = (this.current_boat+2)%this.boats.length;
			this.boats[c].setGrounded(false);
		}
		else this.current_boat = c;
	}

	/**
	 * 检查胜利者
	 * @return 胜利船的id
	 */
	public int checkWinner() {
		for(int i=0;i<this.boats.length;i++) {
			if(this.boats[i].getCurrent_pos()==FINAL_GRID) {
				System.out.println("船"+i+"获胜");
				this.game_state = false;
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 终端输出当前状态
	 */
    public void showCurrentState(){
		for(Boat s : this.boats){
			String res;
			res = "The "+s.getId()+" boat is at"+s.getCurrent_pos();
			System.out.println(res);
		}
		System.out.println("----------------------------------");
	}
     
     //游戏过程
    /*
      public void runGame() {
    	 while(game_state) {
    			 System.out.println(this.getCurrent_boat()+"船走了"+this.onClickDice()+"步");
    			 this.checkCurrentGrid();
    			 this.checkWinner();
    			 this.switchPlayer();
    			 if(this.getCurrent_boat()==0) {
    				 showCurrentState();
    		 }
    	 }
     }
    */
=======
    private int current_boat;

    /** 终点坐标*/
    public static final int FINAL_GRID = 34;
    /** 道具1坐标 前进*/
    public static final int[] PROP1_GRID = { 3, 8, 19, 33 };
    /** 道具2坐标 后退*/
    public static final int[] PROP2_GRID = { 7, 14, 25 };
    /** 道具3坐标 暂停一轮 */
    public static final int[] PROP3_GRID = { 22, 31 };
    /** 道具4坐标 多走一次 */
    public static final int[] PROP4_GRID = { 13, 29 };
    /** 道具1前进步数 */
    public static final int FOWARD_STEP = 5;
    /** 道具2后退步数 */
    public static final int BACK_STEP = -5;

    public Game() {
        super();
        Boat b1 = new Boat(0, 0);
        Boat b2 = new Boat(1, 0);
        Boat b3 = new Boat(2, 0);
        this.boats = new Boat[3];
        boats[0] = b1;
        boats[1] = b2;
        boats[2] = b3;

        this.dice_generator = new Random();
        this.current_boat = 0;
    }

    /**
     * 产生一个1-6之间的随机整数（模拟骰子的功能），并让船前进
     * @return 1-6之间的随机整数
     */
    public int onClickDice() {
        int dice = dice_generator.nextInt(5) + 1;
        this.getCurrentBoat().advance(dice);
        return dice;
    }

    /**
     * 获取当前船的对象
     * @return 当前船的对象
     */
    public Boat getCurrentBoat() {
        return this.boats[this.current_boat];
    }

    /**
     * 检查船的当前位置是否有道具并进行响应
     */
    public void checkCurrentGrid() {
        int i;
        for (i = 0; i < PROP1_GRID.length; i++) {
            if (this.boats[this.current_boat].getCurrent_pos() == PROP1_GRID[i]) {
                this.boats[this.current_boat].advance(FOWARD_STEP);
                System.out.println(this.getCurrent_boat() + "吃到道具1,多走5格");
            }
        }
        for (i = 0; i < PROP2_GRID.length; i++) {
            if (this.boats[this.current_boat].getCurrent_pos() == PROP2_GRID[i]) {
                this.boats[this.current_boat].advance(BACK_STEP);
                System.out.println(this.getCurrent_boat() + "吃到道具2,后退5格");

            }
        }
        for (i = 0; i < PROP3_GRID.length; i++) {
            if (this.boats[this.current_boat].getCurrent_pos() == PROP3_GRID[i]) {
                this.boats[this.current_boat].setGrounded(true);
                System.out.println(this.getCurrent_boat() + "吃到道具3,暂停一轮");
            }
        }
        for (i = 0; i < PROP4_GRID.length; i++) {
            if (this.boats[this.current_boat].getCurrent_pos() == PROP4_GRID[i]) {
                System.out.println(this.getCurrent_boat() + "吃到道具4,再走一次");
                this.setCurrent_boat((this.current_boat + 2) % this.boats.length);
            }
        }

    }

    /**
     * 根据上一步的情况更新当前玩家
     */
    public void switchPlayer() {
        int c = (this.current_boat + 1) % this.boats.length;
        if (this.boats[c].isGrounded() == true) {
            this.current_boat = (this.current_boat + 2) % this.boats.length;
            this.boats[c].setGrounded(false);
        } else
            this.current_boat = c;
    }

    /**
     * 检查胜利者
     * @return 胜利船的id
     */
    public int checkWinner() {
        for (int i = 0; i < this.boats.length; i++) {
            if (this.boats[i].getCurrent_pos() == FINAL_GRID) {
                System.out.println("船" + i + "获胜");
                this.game_state = false;
                return i;
            }
        }
        return -1;
    }

    /**
     * 终端输出当前状态
     */
    public void showCurrentState() {
        for (Boat s : this.boats) {
            String res;
            res = "The " + s.getId() + " boat is at" + s.getCurrent_pos();
            System.out.println(res);
        }
        System.out.println("----------------------------------");
    }

    //游戏过程
    public void runGame() {
        while (game_state) {
            System.out.println(this.getCurrent_boat() + "船走了" + this.onClickDice() + "步");
            this.checkCurrentGrid();
            this.checkWinner();
            this.switchPlayer();
            if (this.getCurrent_boat() == 0) {
                showCurrentState();
            }
        }
    }
>>>>>>> f371e2ce684b423b274773ab91e43f33909a95a0

    //Model测试
    /*
       public static void main(String[] args) {
    
    	Game g = new Game();
    	g.runGame();
    }
     */

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
