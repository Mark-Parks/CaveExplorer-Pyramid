/**
 * 
 */
package TheoDevinMinigame;

import java.util.Scanner;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

/**
 * @author BT_1N3_13
 *
 */
public class TheoRoom extends NPCRoom {

	private boolean active;
	/**
	 */
	public TheoRoom( String description) {
		super(description);
		active = true;
	}

	public String getContents() {
		if(active) {
		return "T";
		}else {
			return super.getContents();
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
		return "wdsaez";
	} 
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s','a' or press 'z' to play a game");
	}
	public void performAction(int direction) {
		if(direction == 5 ) {
			badJoke();
		}
		else {
			super.performAction(direction);
		}
	}

	private void badJoke() {
		CaveExplorer.print("Heres a joke");
		CaveExplorer.print("There are 10 types of people in the world those who understand binary and those who dont");
	}
}