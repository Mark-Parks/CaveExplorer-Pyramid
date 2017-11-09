package caveExplorer;

public class TristanRoom extends NPCRoom {

	boolean explored = false;
	int fullyHealed = 100;
	
	public TristanRoom(String description) {
		super(description);
		super.setFloor(0);
	}
	
	public void enter() {
		super.setContents("There is a fountain in this room. You drink from it and you are"
				+ "magically healed!");
		CaveExplorer.inventory.setHp(fullyHealed);
	}
	
	public String getContents() {
		if(super.getContents() == " ") {
			return "F";
		}else {
			return "F";
		}
	}
	
}