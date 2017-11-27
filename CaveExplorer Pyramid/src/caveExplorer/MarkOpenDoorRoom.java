package caveExplorer;

public class MarkOpenDoorRoom extends NPCRoom{
	
	private boolean doorIsLocked;
	private int floor;
	private int row;
	private int col;
	private int dir;
	
	public MarkOpenDoorRoom(String description, CaveRoom room, int floor, int row, int col, int dir) {
		super(description);
		this.doorIsLocked = doesRoomHaveLockedDoor(room);
		this.floor = floor;
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	private boolean doesRoomHaveLockedDoor(CaveRoom room) {
		for(int i = 0; i < 4; i++) {
			if(room.getDoor(i) != null && room.getDoor(i).isLocked()) {
				return true;
			}
		}
		return false;
	}
	
	public void printValidMoves() {
		if(doorIsLocked) CaveExplorer.print("You can only enter 'w','d','s', 'a', or press 'e' to inspect your surroundings, or 'o' to open the door for a key.");
		else CaveExplorer.print("You can only enter 'w','d','s', 'a', or press 'e' to inspect your surroundings");
	}
	public String validMoves() {
		if(doorIsLocked) return "wdsaeo";
		else return "wdsae";
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
			}else if (doorIsLocked){
				CaveExplorer.print("You see that this seemingly seamless limestone wall has a key hole.");
				CaveExplorer.print("Maybe you'll find the key to open it somewhere else in the pyramid.");
			}else CaveExplorer.print("The door has been opened.");
		}
		else if(direction == 5) {
			if(CaveExplorer.inventory.getKeys() > 0) {
				CaveExplorer.print("You use the key, and with a satifying *KACHUNK*, the door slides open.");
				int rowToOpen = row;
				int colToOpen = col;
				if(dir == NORTH) {
					rowToOpen--;
				}
				if(dir == EAST) {
					colToOpen++;
				}
				if(dir == SOUTH) {
					rowToOpen++;
				}
				if(dir == WEST) {
					colToOpen--;
				}
				CaveExplorer.caves[floor][row][col].setConnection(dir, CaveExplorer.caves[floor][rowToOpen][colToOpen], new Door());
				CaveExplorer.inventory.useKey();
				this.doorIsLocked = false;
			}else {
				CaveExplorer.print("You don't have any keys.");
			}
		}
		else {
			CaveExplorer.print("Error, please report.");
		}
	}
	
	
	public String getContents() {
		return super.getContents();
	}
}
