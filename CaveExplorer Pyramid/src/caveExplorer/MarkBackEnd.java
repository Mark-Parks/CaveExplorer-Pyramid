package caveExplorer;

public class MarkBackEnd implements WilliamSupporter{

	private MarkSupporter frontend;
	
	public MarkBackEnd(MarkSupporter frontend) {
		this.frontend = frontend;
		
	}

	private int[][] board;
	private int[] coords1;
	private int[] coords2;
	
	public static void main(String[] args) {
	}
	
	public void cancel() {
		
	}
	
	public void swap(int row1, int col1, int row2, int col2, int[][]array) {
		coords1[0] = col1;
		coords1[1] = row1;
		coords2[0] = col2;
		coords2[1] = row2;
		int x = board[coords1[0]][coords1[1]];
		board[coords1[0]][coords1[1]] = board[coords2[0]][coords2[1]];
		board[coords2[0]][coords2[1]] = x;
	}
	
	public int rowSum(int row, int[][] array){
		int sum = 0;
		for (int i =0; i < array[row].length; i++){
			sum += array[row][i];
		}
		array[row][array[row].length] = sum;
		return sum;
	}
	
	public int colSum(int col, int[][] array){
		int sum = 0;
		for (int i =0; i < array[col].length; i++){
			sum += array[i][col];
		}
		array[array[col].length][col] = sum;
		return sum;
	}
	
	public void createBoard(int n) {
		int[] numbers = new int[n*n];
		for(int i = 0; i < numbers.length; i++) {
			int newNumber = (int)(Math.random()*n*n-1)+1;
			while(contains(numbers, newNumber)) {
				newNumber = (int)(Math.random()*n*n-1)+1;
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
		board = squareArray;
	}
	
	private boolean diagonalCheck(int[][] array) {
		int diagonalSEsum = 0;
		int diagonalNEsum = 0;
		
		int start = array.length - 2;
		for(int i = 0; i < start; i++) {
			diagonalSEsum += array[i][i];
		}
		for(int i = 0; i < start; i++) {
			diagonalNEsum += array[i][start];
		}
		return diagonalSEsum == diagonalNEsum;
	}

	private boolean rowCheck(int[][] array) {
		return rowSum(0,array) == rowSum(1,array) && rowSum(0,array) == rowSum(2,array);
	}

	private boolean columnCheck(int[][] array) {
		return colSum(0,array) == colSum(1,array) && colSum(0,array) == colSum(2,array);
	}
	
	public boolean contains(int[] nums, int num) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public  boolean stillPlaying() {
		return !victorious();
	}
	
	public boolean victorious() {
		return columnCheck(board) && rowCheck(board) && diagonalCheck(board);
	}//checks if won
	
	public int[][] getBoard(){
		return board;
	}
}
