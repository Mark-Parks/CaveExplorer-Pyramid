package WeixiongTristanMinigame;

public class Block {
	
	private String contents;
	public boolean containsPlayer;
	public boolean containsMummy;
	
	public Block(String contents) {
		containsPlayer = false;
		this.contents = contents;
		containsMummy =  false;
	}
	
	public Block() {
		this.contents = "   ";
		containsPlayer = false;;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isOccupied() {
		return containsPlayer;
	}

	public void setOccupied(boolean isOccupied) {
		this.containsPlayer = isOccupied;
	}

	public boolean containsMummy() {
		return this.contents.equals(" M ");
	}
	
	public void enterMummy() {
		contents = " M ";
		containsMummy = true;
	}
	
	public void leaveMummy() {
		contents = "   ";
		containsMummy = false;
	}

	public void enter() {
		contents = " X ";
		containsPlayer = true;
	}
	
	public void leave() {
		contents = "   ";
		containsPlayer = false;
	}
}
