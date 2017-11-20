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
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	public void interpretInput(String input) {
		while(!isValid(input)){
			printValidMoves();
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if(direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
	}
	public void performAction(int direction) {
		if(direction == 5) {
			setFloor(getFloor()+1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][0][0];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			System.out.println("The stairway closes behind you as you exit.");
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
