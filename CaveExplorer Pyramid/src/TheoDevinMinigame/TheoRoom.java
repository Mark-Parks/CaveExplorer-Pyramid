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
	 * @param description
	 */
	public TheoRoom(String description) {
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
		return "wdsaz";
	} 
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s','a' or press 'z' to play a game");
	}
	private void performAction(int direction) {
		if(direction == 4 ) {
			guessNumber();
		}
		else {
			CaveExplorer.print("That key does nothing OmegaLUL");
		}
	}

	private void guessNumber() {
		String z ="7";
		Scanner in = new Scanner(System.in);
		CaveExplorer.print("Guess my random number Xd Kappa haHAA");
		while(!in.nextLine().equals(z)) {
			CaveExplorer.print("Thats the wrong number");
		}
		CaveExplorer.print("Wow U guessed the right number");
	}
}