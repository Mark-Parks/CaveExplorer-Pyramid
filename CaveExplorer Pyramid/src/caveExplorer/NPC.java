package caveExplorer;

public class NPC {

	//fields 
	private CaveRoom[][] floor;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	

	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person standing in the room waiting to talk to you. Press 'e' to talk"; 
		this.inactiveDescription = "that guy is still here";
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

	public void interact() {
		CaveExplorer.print("Let's interact! type 'bye' to leave");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("I dont do anything else");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("see ya");
		active = false;
	}

	public String getSymbol() {
	return "M";
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getDescription() {
		return activeDescription;
	}

	public void setPosition(int row, int col) {
		if(row > -1 && row < floor.length && col > -1 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		if(active) {
			int[] move = calculateMove();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
		}
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int index = 0;
		
	}
}
