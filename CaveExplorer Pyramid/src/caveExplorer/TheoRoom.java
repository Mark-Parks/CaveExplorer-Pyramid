package caveExplorer;

public class TheoRoom extends NPCRoom {
	
	public TheoRoom( String description) {
		super(description);
	}

	public String getContents() {
		if(CaveExplorer.inventory.isNotSpooked()) {
			return "T";
		}else {
			return super.getContents();
		}
	}
	public String getDescription() {
		if(CaveExplorer.inventory.isNotSpooked()) {
			return "A skeleton lies against the wall of the hallway. While dead it seems to be looking at you. It asks you 'What is it you fear most explorer?'";
		}else {
			return "A sense of dread looms over you as your greatest fear appears in front of you.";
		}
	}
	
	public String validMoves() {
		return "wdsaez";
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
	public void printValidMoves() {
		if(CaveExplorer.inventory.isNotSpooked())
			System.out.println("You can only enter 'w','d','s','a' or press 'e' to inspect your surroundings, or press 'z' answer the skeleton.");
		else System.out.println("You can only enter 'w','d','s','a' or press 'e' to inspect your surroundings, or press 'z' to face your fear.");
	}
	public void performAction(int direction) {
		String playerFear = CaveExplorer.inventory.getPlayerFear();
		if(direction == 5 ) {
			if(CaveExplorer.inventory.isNotSpooked()) {
				CaveExplorer.print("You turn to the skeleton and say that your fear is...");
				String input = CaveExplorer.in.nextLine();
				while(!fearfulInput(input)){
					CaveExplorer.print("The skeleton crackles 'That's isn't sincere...Tell me something that SCARES yoouu!'");
					CaveExplorer.print("You turn to the skeleton and say that your fear is...");
					input = CaveExplorer.in.nextLine();
				}
				CaveExplorer.print("The skeleton crackles 'Good to know...Hee Hee'");
				CaveExplorer.inventory.setPlayerFear(input);
				CaveExplorer.inventory.setSpooked(true);
			}else {
				CaveExplorer.print("You charge at "+playerFear+" hoping it goes away!");
				double chance = Math.random();
				if(chance > .5) {
					CaveExplorer.print("As you run into "+playerFear+", it fades from the air. As you suspected. It was just a hallucination. You hear the skeleton laughter crackle throughout the hallway.");
				}else {
					CaveExplorer.print("As you run into "+playerFear+", You trip and faceplant into the ground. -5 HP. You hear the skeleton laughter crackle throughout the hallway.");
					CaveExplorer.inventory.setHp(CaveExplorer.inventory.getHp() - 5);
				}
			}
		}
		else {
			super.performAction(direction);
		}
	}

	private boolean fearfulInput(String input) {
		return (input.indexOf(" ") == -1) && (input.indexOf("nothing") == -1);
	}
}