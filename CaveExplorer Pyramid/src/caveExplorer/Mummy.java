package caveExplorer;

public class Mummy extends NPC {

	private 
	
	
	public Mummy() {
		
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