package caveExplorer;

public class WeiCustomRoom extends NPCRoom {
	
	private String description = "Wowie! A preserved relic! 'How much is it worth?' you wonder.";
	private boolean active;
	private String[] artifactDesc = {"A simple clay statue. Nothing to exciting but still worth something",
									 "A scroll fully illustrated! Definately worth something to scholars.",
									 "A gold amulet! Only the rich could afford something so luxurious.",
									 "A humongous Gemstone! Truely stuff of royalty. This sets you up for life."};
	
	public WeiCustomRoom(String description) {
		super(description);
		this.active = true;
	}
	
	public void enter() {
		System.out.println("");
	}

	public String getContents() {
		if(super.getContents() == " ") {
			return "A";
		}else {
			return super.getContents();
		}
	}
	public String getDescription() {
		if(active) {
			return description;
		}else {
			return super.getDescription();
		}
	}
	public String validMoves() {
		return "wdsaec";
	} 
	private boolean isValid(String input) {
		return validMoves().indexOf(input) != -1 && input.length() == 1;
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w','d','s','a' or press 'e' to inspect your surroundings or press 'c' to collect the artifact.");
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
	//things
	public void performAction(int direction) {
		if(direction == 5) {
			if(active) {
				double chance = Math.random();
				if(chance < .40) {
					System.out.println(artifactDesc[0]);
					CaveExplorer.inventory.addArtifact(0);
				}else if(chance <.70) {
					System.out.println(artifactDesc[1]);
					CaveExplorer.inventory.addArtifact(1);
				}else if(chance <.90) {
					System.out.println(artifactDesc[2]);
					CaveExplorer.inventory.addArtifact(2);
				}else {
					System.out.println(artifactDesc[3]);
					CaveExplorer.inventory.addArtifact(3);
				}
				active = false;
			}else {
				System.out.println("You have already collected the artifact here.");
			}
		}
		else {
			super.performAction(direction);
		}
	}
}
