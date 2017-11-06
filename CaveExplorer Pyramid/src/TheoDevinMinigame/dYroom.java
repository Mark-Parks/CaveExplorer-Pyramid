package TheoDevinMinigame;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class dYroom extends NPCRoom {
	
	

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
	public void act() {
		CaveExplorer.print("There is nothing to interact with.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("e")) {
			CaveExplorer.print("Far off in the distance, you hear a damsel in distress.");
			 s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Far off in the distance, you hear a damsel in distress.");
		active = true;
	}
	public void performAction(int direction) {
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				npc.interact();
			}else {
				
				npc.act();
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
}
