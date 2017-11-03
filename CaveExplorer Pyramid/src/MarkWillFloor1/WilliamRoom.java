package MarkWillFloor1;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;

public class WilliamRoom extends NPCRoom {

	private String board;
	
	public WilliamRoom(String description) {
		super(description);
		display(createSquare(3));
	}
	
	public void display(int[][] x) {
		
	}
	public int[][] createSquare(int n) {
		int[] numbers = new int[n*n];
		for(int i = 0; i < numbers.length; i++) {
			int newNumber = (int)(Math.random()*n*n);
			while(contains(numbers, newNumber)) {
				newNumber = (int)(Math.random()*n*n);
			}
			numbers[i] = newNumber;
		}
		
		int[][]squareArray = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				squareArray[i][j] = numbers[i*3+j];
			}
		}
		return squareArray;
	}
	public boolean contains(int[] nums, int num) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == num) {
				return true;
			}
		}
		return false;
	}
	

	
}
