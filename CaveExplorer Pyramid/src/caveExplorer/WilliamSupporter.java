package caveExplorer;

public interface WilliamSupporter {
	
	public void createBoard(int x);
	//creates a board of size [x+1][x+1], only fills up to [x] for col & row
	//the bottom of columns, the rightmost-hand side of rows and the bottom-right corner
	//is used to display the sum of columns, rows and the diagonal
	
	public int[][]getBoard();
	//returns the board
	
	public boolean victorious();
	//checks sums

	public void swap(int a, int b, int c, int d, int[][] board);
	//swaps the numbers at a,b and c,d when i pass them on

	public void updateSums(int[][] board);
	//updates the sum values of the board because the front end
	//won't automatically account for back end after swap
	
}
