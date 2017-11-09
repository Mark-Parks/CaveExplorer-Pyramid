package TheoDevinMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class DYroom extends NPCRoom {
	
	private boolean active;

	public DYroom(String description) {
		super(description);
		active = true;
		// TODO Auto-generated constructor stub
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to perform an action."
				+ " You can press b for a chance to get a hint in one of the minigames");
	}
	
	public String getContents() {
		if(active) {
		return "D";
		}else {
			return super.getContents();
		}
	}
	public String validthings() {
		return "wdsaeb";
	}	
		public void performAction(int direction) {
		if(direction == 5) {
			getNpc().chance();
			CaveExplorer.print("hi im devin and I dab on haters");
		}else {
				CaveExplorer.print("no");
			}
		}
}
