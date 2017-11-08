package caveExplorer;

public class TristanRoom extends CaveRoom {

	boolean explored = false;
	int fullyHealed = 100;
	
	public TristanRoom(String description) {
		super(description);
	}
	
	public void enter() {
		super.setContents("There is a fountain in this room. You drink from it and you are"
				+ "magically healed!");
		Inventory.setHp(fullyHealed);
	}
	
}