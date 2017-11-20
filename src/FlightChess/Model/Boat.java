package FlightChess.Model;

import FlightChess.View.GameView;

public class Boat {
	
	private int id; 
	private int current_pos;
	private int isBost;
	
	public Boat(int id, int current_pos) {
		this.id = id;
		this.current_pos = current_pos;
	}
	
	public void advance(int i) {
		this.current_pos +=i;
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
	
	
	

}
