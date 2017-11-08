package caveExplorer;

public class WilliamStairwayRoom extends NPCRoom {

	public WilliamStairwayRoom(String description) {
		super(description);
		
	}
	public void printValidMoves() {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to perform an action,"
				+ " or 'u' to go up the stairs.");
	}
	public String validMoves() {
		return "wdsaeu";
	}
	public void performAction(int direction) {
		if(direction == 5) {
			setFloor(getFloor()+1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][0][0];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
		else {
			CaveExplorer.print("Invalid input");
		}
	}
	
	
	public String getContents() {
		if(super.getContents() == " ") {
			return "S";
		}else {
			return "S";
		}
	}
}
