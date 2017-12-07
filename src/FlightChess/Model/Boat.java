package FlightChess.Model;

import FlightChess.View.GameView;

/**
 * Class Boat
 */

public class Boat {
	/** the ID of each boat */
	private int id; 
	/** current position of boat */
	private int current_pos;
	/** Whether or not to be banned for a round */
	private boolean grounded;
	/** the color of each boat */
	private String color;

	/**
	 * constructor
	 * @param i ID of boat
	 * @param cp the initial position
	 * @param c color
	 */
	public Boat(int i, int cp,String c) {
		this.id = i;
		this.current_pos = cp;
		this.grounded = false;
		this.color = c;
	}
	
	/**
	 * To advance the ship in the sea and update the current position of the ship
	 * @param i Forward step
	 * @param g Game view
	 */
	public void advance(int i,GameView gv) {
		if((this.current_pos+i)>34) {
			gv.advanceForBoatByStep(this.id,34-this.getCurrent_pos());
			gv.advanceForBoatByStep(this.id, -(i-(34-this.getCurrent_pos())));
			i=2*(34-this.getCurrent_pos())-i;
		}
		else {
			gv.advanceForBoatByStep(this.id, i);
		}
		this.setCurrent_pos(this.getCurrent_pos()+i);
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
