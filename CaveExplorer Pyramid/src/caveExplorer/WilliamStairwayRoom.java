package caveExplorer;

public class WilliamStairwayRoom extends NPCRoom {

	private int upR;
	private int upC;
	private int downR;
	private int downC;
	
	public WilliamStairwayRoom(String description, int upRow, int upCol, int downRow, int downCol) {
		super(description);
		this.upR = upRow;
		this.upC = upCol;
		this.downR = downRow;
		this.downC = downCol;
	}
	
	public void printValidMoves() {
		if(this.getFloor() == 0) {
			CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to perform an action or " 
					+ "'i' to go down the stairs.");
		}else if(this.getFloor() == 1) {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to perform an action, "
				+ "'u' to go up the stairs, or "
				+ "'i' to go down the stairs.");
		}
		else {
			CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to perform an action, or"
					+ "'i' to go down the stairs.");
		}
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
			CaveExplorer.inventory.updateMap();
		}
	}
	public void performAction(int direction) {
		if(direction == 4) {
			if(getNpc() != null && getNpc().isActive()) {
				getNpc().interact();
			}else {
				CaveExplorer.print("You look at the stairs and see that this temple has multiple floors.");
			}
		}
		else if(direction == 5 && getFloor() < 2) {
			setFloor(getFloor()+1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][upR][upC];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			System.out.println("The climb up the stairs leaves you winded.");
		}
		else if(direction == 6 && getFloor() > 0) {
			setFloor(getFloor()-1);
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = CaveExplorer.caves[getFloor()][downR][downC];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			System.out.println("You head down.");
		}
		else {
			CaveExplorer.print("Invalid input.");
		}
	}
	
	
	public String getContents() {
		if(super.getContents() == " ") {
			return "S";
		}else {
			return super.getContents();
		}
	}
}
