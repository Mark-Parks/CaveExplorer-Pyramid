package caveExplorer;

public class MarkRoom extends NPCRoom{
	
	private boolean containKey;
	
	public MarkRoom(String description) {
		super(description);
		this.containKey = true;
	}
	public void printValidMoves() {
		if(containKey)
		CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings, or 'c' to collect the key");
		else CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings");
	}
	public String validMoves() {
		if(containKey) return "wdsaec";
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
			}else if (containKey){
				CaveExplorer.print("The only distinct object near you is the key.");
			}else CaveExplorer.print("You see the imprint of the key's shape in the ground.");
		}
		else if(direction == 5) {
			System.out.println("You grab the key. Maybe it will unlock a door.");
			this.containKey = false;
			CaveExplorer.inventory.addKey();
			this.setDescription("There is an imprint of the key you picked up earlier in the ground.");
		}

		else {
			CaveExplorer.print("Invalid input");
		}
	}
	
	
	public String getContents() {
		if(super.getContents() == " " && containKey) {
			return "K";
		}else {
			return super.getContents();
		}
	}
}
