package caveExplorer;

public class MarkOpenDoorRoom extends NPCRoom{
	
	private boolean doorIsLocked;
	private int doorDirection;
	private CaveRoom lockRoom;
	
	public MarkOpenDoorRoom(String description, CaveRoom room) {
		super(description);
		this.lockRoom = room;
		this.doorIsLocked = doesRoomHaveLockedDoor(room);
	}
	private boolean doesRoomHaveLockedDoor(CaveRoom room) {
		for(int i = 0; i < 4; i++) {
			if(room.getDoor(i) != null && room.getDoor(i).isLocked()) {
				doorDirection = i;
				return true;
			}
		}
		return false;
	}
	
	public void printValidMoves() {
		if(doorIsLocked) CaveExplorer.print("You can only enter 'w','d','s', 'a', or press 'e' to inspect your surroundings, or 'o' to open the locked door but use a key.");
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
				CaveExplorer.print("You see that this giant door has a slot for a key. Maybe it's somewhere else in the temple.");
			}else CaveExplorer.print("The door has been opened.");
		}
		else if(direction == 5) {
			if(CaveExplorer.inventory.getKeys() > 0) {
				System.out.println("You use the key and with a satifying *KACHUNK* the to door slides open.");
				lockRoom.getDoor(doorDirection).setLocked(false);
				lockRoom.getDoor(doorDirection).setOpen(true);			
				CaveExplorer.inventory.useKey();
				this.doorIsLocked = false;
			}else {
				System.out.println("You don't have any keys.");
			}
		}

		else {
			CaveExplorer.print("Invalid input");
		}
	}
	
	
	public String getContents() {
		if(super.getContents() == " ") {
			return " ";
		}else return super.getContents();
	}
}
