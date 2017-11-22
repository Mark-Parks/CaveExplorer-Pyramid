package caveExplorer;

public class MarkOpenDoorRoom extends NPCRoom{
	
	private boolean doorIsLocked;
	
	public MarkOpenDoorRoom(String description) {
		super(description);
		this.doorIsLocked = true;
	}
	public void printValidMoves() {
		if(doorIsLocked) CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings, or 'o' to open the locked door but use a key.");
		else CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings");
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
			System.out.println("You use the key and with a satifying *KACHUNK* the to door slides open.");
			CaveExplorer.inventory.useKey();
			this.doorIsLocked = false;
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
