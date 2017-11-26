package caveExplorer;

public class TheoDevinMinigameRoom extends NPCRoom{

	private DevinFrontEnd minigame;
	
	public TheoDevinMinigameRoom(String description) {
		super(description);
		this.minigame = new DevinFrontEnd();
	}
	public void printValidMoves() {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to perform an action,"
				+ " or 'f' to play the");
	}
	public String validMoves() {
		return "wdsaef";
	}
	public boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() ==1;
	}
	public void interpretInput(String input) {
		while(!isValid(input)) {
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
			minigame.gameBegins();
		}else {
			CaveExplorer.print("You should never see this");
		}
	}
	public String getContents() {
		if(super.getContents() == " ") {
			return "T";
		}else {
			return super.getContents();
		}
	}

}
