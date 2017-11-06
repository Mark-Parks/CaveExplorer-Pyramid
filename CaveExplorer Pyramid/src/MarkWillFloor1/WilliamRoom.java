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
	
	public String display(int[][] array) {
		int text = "";
		for(int i = 0; i < array[0].length; i++){
			for(int j = 0; j < array[0].length; j++){
				text += array[i][j];
			}
		}
		return text;
	}
	
	public void swapDialogue(){
		
	}
	
	public void swap(int row1, int col1, int row2, int col2, int[][] array){
		int x = array[row1][col1];
		array[row1][col1] = array[row2][col2];
		array[row2][col2] = int x;
	}
	
	public void rowSum(int row, int[][] array){
		int sum = 0;
		for (int i =0; i < array[row].length; i++;){
			sum += array[row][i];
		}
		array[row][array[row].length] = sum;
	}
	
	public void colSum(int col, int[][] array){
		int sum = 0;
		for (int i =0; i < array[col].length; i++;){
			sum += array[i][col];
		}
		array[array[col].length][col] = sum;
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
		
		int[][]squareArray = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				squareArray[i][j] = numbers[i*3+j];
			}
		}
		for(int i = 0; i < n; i++){
			rowSum(i, squareArray);
		}
		for(int i = 0; i < n; i++){
			colSum(i, squareArray);
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
