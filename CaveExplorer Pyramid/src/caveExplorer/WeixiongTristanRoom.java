package caveExplorer;

public class WeixiongTristanRoom extends NPCRoom{
	
	private TristanFrontEnd game;
	private boolean played;
	
	public WeixiongTristanRoom(String description) {
		super(description);
		game =  new TristanFrontEnd();
		played = false;
	}
	public void printValidMoves() {
		if(played) {
			CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to inspect your surroundings.");
		
		}else{
			CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings,"
				+ " or 'f' to approach the final challenge. or 'k' if the game doesn't work.");
		}
	}
	public String validMoves() {
		return "wdsaefk";
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
		if(direction == 5 && !played) {
			game.play();
			played = true;
			super.setDescription("This was the final challenge room.");
		}
		else if(direction == 6) {
			CaveExplorer.inventory.addKey();
			super.setDescription("This was the final challenge room. It didn't work so you get the key anyway to complete the game.");
		} else {
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
