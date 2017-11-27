package caveExplorer;

public class NPC {

	private CaveRoom[][][] pyramid = CaveExplorer.caves;
	private int currentFlr;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	
	public NPC() {
		this.activeDescription = ""; 
		this.inactiveDescription = "";
		this.currentCol = -1;
		this.currentRow = -1;
		this.currentFlr = -1;
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
	return "P";
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getDescription() {
		return activeDescription;
	}

	public void setPosition(int flr, int row, int col) {
		if(flr > -1 && flr < pyramid.length && row > -1 && row < pyramid[flr].length && col > -1 && col < pyramid[flr][row].length && pyramid[flr][row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			
			currentFlr = flr;
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)pyramid[flr][row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		if(active) {
			int[] move = calculateMove();
			int newFlr = move[0];
			int newRow = move[1];
			int newCol = move[2];
			setPosition(newFlr,newRow, newCol);
		}
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
		int index = (int)(Math.random() * possibleMoves.length);
		int[] newPosition = new int[2];
		newPosition[0] = currentRow+possibleMoves[index][0];
		newPosition[1] = currentCol+possibleMoves[index][1];
		while(currentRoom.getDoor(index) == null||!(CaveExplorer.caves[currentFlr][newPosition[0]][newPosition[1]] instanceof NPCRoom)) {
			index = (int)(Math.random() * possibleMoves.length);
			newPosition[0] = currentRow+possibleMoves[index][0];
			newPosition[1] = currentCol+possibleMoves[index][1];
		}
		return newPosition;
	}
}
