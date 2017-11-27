package caveExplorer;

public class DevinRoom extends NPCRoom {
	
	private boolean active;

	public DevinRoom(String description) {
		super(description);
		active = true;
		// TODO Auto-generated constructor stub
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s', or 'a' or press 'e' to inspect your surroundings,"
				+ " or press 'b' for a chance to get a hint in one of the minigames");
	}
	
	public String getContents() {
		if(active) {
			return "D";
		}else {
			return super.getContents();
		}
	}
	public String validMoves() {
		return "wdsaeb";
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
			if(active) {
				double chance = Math.random();
				if(chance < .34) {
					CaveExplorer.print("A spirt tells you 'For the 1st Floor Challenge, the rows and colums must add to 34'!");
				}else if(chance < .67) {
					CaveExplorer.print("A spirt tells you 'For the 2nd Floor Challenge, if you mess up the next time you visit the room will have changed'!");
				}else CaveExplorer.print("A spirt tells you 'For the 3rd Floor Challenge, sometimes not moving is the best option'!");
				active = false;
			}else {
				CaveExplorer.print("You have already asked the spirts for hints here.");
			}
		}else {
			super.performAction(direction);
		}
	}
}
