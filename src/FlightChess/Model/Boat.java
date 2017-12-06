package FlightChess.Model;

/**
 * 小船类
 */

public class Boat {
	/** the ID of each boat */
	private int id; 
	/** current position of boat */
	private int current_pos;
	/** Whether or not to be banned for a round */
	private boolean grounded;

	
	/**
	 * constructor
	 * @param i ID of boat
	 * @param cp the initial position
	 */
	public Boat(int i, int cp) {
		this.id = i;
		this.current_pos = cp;
		this.grounded = false;
	}
	
	/**
	 * To advance the ship in the sea and update the current position of the ship
	 * @param i Forward step
	 */
	public void Advance(int i) {
		this.current_pos=(this.current_pos+i)%(35);
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
