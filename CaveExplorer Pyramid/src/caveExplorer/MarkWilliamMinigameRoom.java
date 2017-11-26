package caveExplorer;

public class MarkWilliamMinigameRoom extends NPCRoom {
	
	private WilliamFrontEnd game;

	public MarkWilliamMinigameRoom(String description) {
		super(description);
		game = new WilliamFrontEnd();
		
	}
	public void printValidMoves() {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to inspect your surroundings,"
				+ " or 'f' to approach the wall.");
	}
	public String validMoves() {
		return "wdsaef";
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
			game.play();
		}
		else {
			CaveExplorer.print("Invalid input");
		}
	}
	
	
	public String getContents() {
		if(super.getContents() == " ") {
			return "G";
		}else {
			return super.getContents();
		}
	}
}