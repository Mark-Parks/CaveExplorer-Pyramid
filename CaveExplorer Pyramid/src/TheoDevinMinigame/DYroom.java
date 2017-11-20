package TheoDevinMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class DYroom extends NPC {
	
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to perform an action."
				+ "You can press z for a description of the room.");
	}
	public String validthings() {
		return "wdsaez";
	}	
		public void performAction(int direction) {
		if(direction == 5) {
			CaveExplorer.print("hi im devin and I dab on haters");
		}else {
				super.performAction(direction);
			}
		}
}
