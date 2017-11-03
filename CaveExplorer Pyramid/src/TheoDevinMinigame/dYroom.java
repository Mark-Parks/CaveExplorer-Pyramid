package TheoDevinMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class dYroom extends NPCRoom {
	
	public NPC npc;

	public dYroom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to perform an action."
				+ "You can press z for a description of the room.");
	}
	public String validthings() {
		return "wdsaez";
	}	
	private void performAction(int direction) {
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				CaveExplorer.print("There is nothing");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
}
