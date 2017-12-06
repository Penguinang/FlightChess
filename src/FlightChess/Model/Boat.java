package FlightChess.Model;

/**
 * 小船类
 */

public class Boat {
	/** 每个小船对应的ID */
	private int id; 
	/** 小船当前的位置 */
	private int current_pos;
	/** 是否被禁足一轮 */
	private boolean grounded;
	
	/**
	 * 小船构造函数
	 * @param i 小船ID
	 * @param cp 小船初始位置
	 */
	public Boat(int i, int cp) {
		this.id = i;
		this.current_pos = cp;
		this.grounded = false;
	}
	
	/**
	 * 使船在海中前进,更新船的当前位置
	 * @param i 船在海中前进的步数
	 */
	public void advance(int i) {
		this.current_pos=(this.current_pos+i)%35;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCurrent_pos() {
		return current_pos;
	}
	public void setCurrent_pos(int current_pos) {
		this.current_pos = current_pos;
	}

	public boolean isGrounded() {
		return grounded;
	}

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}


	
	

}
