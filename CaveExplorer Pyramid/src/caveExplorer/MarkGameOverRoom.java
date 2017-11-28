package caveExplorer;

public class MarkGameOverRoom extends NPCRoom {

	public MarkGameOverRoom(String description) {
		super(description);
	}
	
	public void enter() {
		System.out.println("");
	}

	public String getContents() {
		if(super.getContents() == " ") {
			return "E";
		}else {
			return super.getContents();
		}
	}
	public String getDescription() {
		return "This is the end of the Pyramid. You have made to the goal";
	}
	public String validMoves() {
		return "wdsaec";
	} 
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s','a' or press 'e' to end the game!");
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
			CaveExplorer.print("As you make your way up the final center spiral of the Pyramid, you see the sun shine above. You are outside! You have done it!");
			CaveExplorer.print("Congratulations on making it through the Pyramid! Hope you enjoyed!");
			CaveExplorer.playing = false;
		}
	}
	//things
	
}
