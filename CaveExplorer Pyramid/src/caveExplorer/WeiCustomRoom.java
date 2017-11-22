package caveExplorer;

import java.util.Scanner;

public class WeiCustomRoom extends NPCRoom {
	
	private boolean active;
	
	public WeiCustomRoom(String description) {
		super(description);
		this.active = true;
	}
	
	public void enter() {
		System.out.println("");
	}

	public String getContents() {
		if(super.getContents() == " ") {
			return "A";
		}else {
			return "A";
		}
	}
	public String getDescription() {
		if(active) {
		return super.getDescription()+"\n"+"If You want to play a game press 'z'";
		}else {
			return super.getDescription();
		}
	}
	public String validMoves() {
		return "wdsaec";
	} 
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s','a' or press 'e' to inspect your surroundings.");
	}
	public void performAction(int direction) {
		if(direction == 5 ) {
			System.out.println("");
		}
		else {
			super.performAction(direction);
		}
	}
}
