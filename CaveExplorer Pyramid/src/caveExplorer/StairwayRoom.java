package caveExplorer;

public class StairwayRoom extends CaveRoom {

	public StairwayRoom(String description) {
		super(description);
		
	}
	public void printMoves() {
		CaveExplorer.print("You can only enter 'w' 'a' 's' 'd' or type 'u' to go up the stairs");
	}
	public String validMoves() {
		return "wdsau";
	}
	public void performAction(int direction) {
		if(direction == 4) {
			
		}
	}
}
