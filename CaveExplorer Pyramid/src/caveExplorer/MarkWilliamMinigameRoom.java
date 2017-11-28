package caveExplorer;

public class MarkWilliamMinigameRoom extends NPCRoom {
	
	private WilliamFrontEnd game;
	private boolean played;

	public MarkWilliamMinigameRoom(String description) {
		super(description);
		game = new WilliamFrontEnd();
		played = false;
	}
	public void printValidMoves() {
		if(played) {
			CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to inspect your surroundings.");
		
		}else{
			CaveExplorer.print("You can only enter 'w','d','s', 'a', 'e' to inspect your surroundings,"
				+ " or 'f' to approach the wall.");
		}
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
		if(direction == 5 && !played) {
			game.play();
			int sum = game.getSum();
			if(sum > 150) {
				CaveExplorer.inventory.addArtifact(3);
			}
			else if(sum > 100) {
				CaveExplorer.inventory.addArtifact(2);
			}
			else if(sum > 50) {
				CaveExplorer.inventory.addArtifact(1);
			}
			else {
				CaveExplorer.inventory.addArtifact(0);
			}
			played = true;
			super.setDescription("This is where you solved the magic square puzzle.");
		}
		else if(direction == 5){
			CaveExplorer.print("There is a bare pedestal in the recesses of the wall where you found an artifact.");
		}else{
			CaveExplorer.print("Invalid input.");
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
