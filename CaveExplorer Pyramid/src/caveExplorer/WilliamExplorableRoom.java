package caveExplorer;

public class WilliamExplorableRoom extends CaveRoom {
	
	boolean explored = false;
	
	public WilliamExplorableRoom(String description) {
		super(description);
	}
	
	public void enter() {
		explored = true;
		super.setContents("X"); 
		showContents();
	}
	
	public boolean wasEntered() {
		if(this.explored == true) {
			return true;
		}
		return false;
	}
	public void showContents() {
		if(wasEntered())
		{
			super.setContents("You've been in this room before. There wasn't anything of note.");
		}
	}
	
}
