package caveExplorer;

public class MarkNPC extends NPC {

	private CaveRoom[][][] pyramid = CaveExplorer.caves;
	private int[] attackDMG = {10,20,15,25};
	private String[] attacks = {"The Mummy's spews forth a swarm of toxic locusts! You take "+attackDMG[0]+" damage!",
								"The Mummy lunges at you with its arm! You take "+attackDMG[1]+" damage!",
								"The Mummy's bandages unravel and start to strangle you! You take "+attackDMG[2]+" damage!",
								"The Mummy morphs into a giant crocodile and bites you! You take "+attackDMG[3]+" damage!"};
	private int currentFlr;
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	private String description;
	
	
	public MarkNPC() {
		this.description = "As you feared, this temple is haunted by a spirt, or spirts!\nAnd This Mummy is hostile towards vistors!";
		this.currentFlr = -1;
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
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
	
	public void interact() {
		CaveExplorer.print(description);
	}
	
	public void autoMove() {
		int[] move = calculateMove();
		int newFlr = move[0];
		int newRow = move[1];
		int newCol = move[2];
		setPosition(newFlr,newRow, newCol);
		if(playerSameRoom()) {
			CaveExplorer.print("The Mummy screeches a terrible scream!");
			attackPlayer();
		}
	}
	
	private void attackPlayer() {
		int playerHP = CaveExplorer.inventory.getHp();
		int num = (int)(Math.random() * 4);
		CaveExplorer.print(attacks[num]);
		CaveExplorer.inventory.setHp(playerHP-attackDMG[num]);
		
	}

	private boolean playerSameRoom() {
		return CaveExplorer.currentRoom.equals(this.currentRoom);
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
