package caveExplorer;

public class WilliamStairwayRoom extends NPCRoom {

	public WilliamStairwayRoom(String description) {
		super(description);
		
	}
	public void printValidMoves() {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to perform an action, "
				+ "'u' to go up the stairs, or "
				+ "'i' to go down the stairs.");
	}
	public String validMoves() {
		return "wdsaeui";
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
		if(direction == 4) {
			if(getNpc() != null && getNpc().isActive()) {
				getNpc().interact();
			}else {
				CaveExplorer.print("You look at the stairs and see that this tempe has multiple floors.");
			}
		}
		else if(direction == 5 && getFloor() < 2) {
			setFloor(getFloor()+1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][0][0];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			System.out.println("The climb up the stairs leaves you winded.");
		}
		else if(direction == 6 && getFloor() > 0) {
			setFloor(getFloor()-1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][0][0];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			System.out.println("You head down.");
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
