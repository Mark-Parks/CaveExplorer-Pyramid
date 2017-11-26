package caveExplorer;

public class MarkNPC extends NPC {

	private CaveRoom[][][] pyramid = CaveExplorer.caves;
	private int currentFlr;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	
	public MarkNPC() {
		this.activeDescription = "Spooky Mummy is after you!"; 
		this.inactiveDescription = "There is that Spoopy Mummy!";
		this.currentFlr = -1;
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = false;
	}

	public void setPosition(int flr, int row, int col) {
		if(flr > -1 && flr < pyramid.length && row > -1 && row < pyramid[flr].length && col > -1 && col < pyramid[flr][row].length && pyramid[flr][row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			active = true;
			currentFlr = flr;
			currentRow = row;
			currentCol = col;
			currentRoom = (NPCRoom)pyramid[flr][row][col];
			currentRoom.enterNPC(this);
		}
	}
	
	public void interact() {
		CaveExplorer.print(inactiveDescription);
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print(activeDescription);
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("see ya");
		active = false;
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
	
	public String getSymbol() {
		return "M";
	}
	
	private int[] calculateMove() {
		int[][] possibleMoves = {{0,-1,0},{0,0,1},{0,1,0},{0,0,-1}};
		int index = (int)(Math.random() * possibleMoves.length);
		int[] newPosition = new int[3];
		newPosition[0] = currentFlr+possibleMoves[index][0];
		newPosition[1] = currentRow+possibleMoves[index][1];
		newPosition[2] = currentCol+possibleMoves[index][2];
		while(currentRoom.getDoor(index) == null||!(CaveExplorer.caves[newPosition[0]][newPosition[1]][newPosition[2]] instanceof NPCRoom)) {
			index = (int)(Math.random() * possibleMoves.length);
			newPosition[0] = currentFlr+possibleMoves[index][0];
			newPosition[1] = currentRow+possibleMoves[index][1];
			newPosition[2] = currentCol+possibleMoves[index][2];
		}
		return newPosition;
	}
	
}