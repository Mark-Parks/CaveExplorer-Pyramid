package caveExplorer;

public class WilliamNumberSwap{

	private int[][] board;
	private int[] coords1;
	private int[] coords2;
	
	public static void main(String[] args) {
	}
	
	public WilliamNumberSwap(int size) {
		createSquare(size);
	}
	
	public String display(int[][] array) {
		String text = "";
		for(int i = 0; i < array[0].length; i++){
			for(int j = 0; j < array[0].length; j++){
				text += array[i][j];
			}
		}
		return text;
	}
	
	public void cancel() {
		
	}
	public void swap1(int row1, int col1, int[][] array){
		coords1[0] = col1;
		coords1[1] = row1;
	}
	
	public void swap2(int row2, int col2, int[][] array){
		coords2[0] = col2;
		coords2[1] = row2;
	}
	
	public void swap() {
		int x = board[coords1[0]][coords1[1]];
		board[coords1[0]][coords1[1]] = board[coords2[0]][coords2[1]];
		board[coords2[0]][coords2[1]] = x;
	}
	
	public void rowSum(int row, int[][] array){
		int sum = 0;
		for (int i =0; i < array[row].length; i++){
			sum += array[row][i];
		}
		array[row][array[row].length] = sum;
	}
	
	public void colSum(int col, int[][] array){
		int sum = 0;
		for (int i =0; i < array[col].length; i++){
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
