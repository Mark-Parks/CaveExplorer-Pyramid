package WeixiongTristanMinigame;

public class Block {
	
	private String contents;
	public boolean isVisible;
	public boolean isOccupied;
	
	public Block(String contents) {
		isVisible = false;
		isOccupied = false;
		this.contents = contents;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean containsMummy() {
		return this.contents.equals("M");
	}
	
	public boolean getVisibility() {
		return isVisible;
	}
	
	public void toggleVisibility(){
		 isVisible = !isVisible;
	}
	
}
