package caveExplorer;

public class TristanRoom extends NPCRoom {

	boolean explored = false;
	int fullyHealed = 100;
	
	public TristanRoom(String description) {
		super(description);
		super.setFloor(0);
	}
	
	public void enter() {
		super.setDescription("There is an ominous obsidian obelisk in the room.\n"
				+ "Inscribed with strange, alien sigils, its pointed top nearly touches the ceiling.\n"
				+ "Press 'f' to approach it.");
	}
	
	public void printValidMoves() {
		CaveExplorer.print("You can only enter 'w','d','s', 'a', or 'e' to inspect your surroundings,"
				+ " or 'f' to approach the obelisk.");
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
			if(!explored) {
				double chance = Math.random();
				if(chance < .25) { 
					System.out.println("You feel a soothing warmth from the obelisk. + 20 HP."); 
					CaveExplorer.inventory.setHp(CaveExplorer.inventory.getHp() + 20); 
				}else if(chance < .50) { 
					System.out.println("You feel your wounds heal."); 
					CaveExplorer.inventory.setHp(100);
				} else if(chance < .75) { 
					System.out.println("Disappointingly, nothing happens."); 
				} else { 
					System.out.println("The obelisk is freezing cold to the touch. \n" 
					+ "Your surrounings seem to suddenly darken. -25 HP."); 
					CaveExplorer.inventory.setHp(CaveExplorer.inventory.getHp() - 25); 
				} 
				if(CaveExplorer.inventory.getHp() <= 0) {
					CaveExplorer.playing = false;
				} 
				explored = true;
			}else {
				System.out.println("It's essence has already been used."); 
			}
		} 
	}
	
	
	public String getContents() {
		if(super.getContents() == " ") {
			return "B";
		}else {
			return super.getContents();
		}
	}
}