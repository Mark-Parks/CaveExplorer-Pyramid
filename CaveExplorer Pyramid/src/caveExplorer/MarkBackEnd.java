package caveExplorer;

public class MarkBackEnd implements WilliamSupporter{

	private MarkSupporter frontend;
	private int[][] board;
	private int[] coords1;
	private int[] coords2;
	private int[] rowTotals;
	private int[] colTotals;
	
	public MarkBackEnd(MarkSupporter frontend) {
		System.out.println("test1");
		this.frontend = frontend;
		System.out.println("test1");
		rowTotals = new int[3];
		colTotals = new int[3];
		board = new int[4][4];
		System.out.println("test1");
		createBoard(3);
		System.out.println("test1");
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
	
	public void showRowSum(int row, int[][] array){
		int sum = 0;
		for (int i =0; i < array[row].length; i++){
			sum += array[row][i];
		}
		rowTotals[row] = sum;
		array[row][array[row].length-1] = sum;
	}
	
	public void showColSum(int col, int[][] array){
		int sum = 0;
		for (int i =0; i < array[col].length; i++){
			sum += array[i][col];
		}
		colTotals[col] = sum;
		array[array[col].length-1][col] = sum;
	}
	
	public void showDiagSum(int[][] array){
		int sum = 0;
		for(int i = 0; i < array[0].length-1; i++) {
			sum += array[i][i];
		}
		array[array[0].length-1][array[0].length-1] = sum; 
	}
	
	public void createBoard(int n) {
		System.out.println("test1");
		int[] numbers = new int[n*n];
		System.out.println("test1");
		for(int i = 0; i < numbers.length; i++) {
			int newNumber = (int)(Math.random()*(n*n))+1;
			System.out.println("GEN RANDO NUM");
			while(contains(numbers, newNumber)) {
				newNumber = (int)(Math.random()*(n*n))+1;
			}
			System.out.println("WHILE ECSAPED");
			numbers[i] = newNumber;
		}
		System.out.println("BOARD CREATED");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = numbers[i*3+j];
			}
		}
		System.out.println("test1");
		for(int i = 0; i < n; i++){
			showRowSum(i, board);
		}
		System.out.println("test1");
		for(int i = 0; i < n; i++){
			showColSum(i, board);
		}
		showDiagSum(board);
		System.out.println("test1");
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
		return rowTotals[0] == rowTotals[1] && rowTotals[0] == rowTotals[2];
	}

	private boolean columnCheck(int[][] array) {
		return colTotals[0] == colTotals[1] && colTotals[0] == colTotals[2];
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
