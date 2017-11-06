package caveExplorer;

public class TristanRoom extends CaveRoom {

	boolean explored = false;
	
	public TristanRoom(String description) {
		super(description);
	}
	
	public void enter() {
		super.setContents("X");
		explored = true;
	}
	
	public boolean wasEntered() {
		if(this.explored == true) {
			return true;
		}
		return false;
	}
	
	public void showContents() {
		if(wasEntered()) {
			super.setContents("You've been in this room before!");
		}
	}
}