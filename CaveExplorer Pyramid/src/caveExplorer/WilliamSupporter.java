package caveExplorer;

public interface WilliamSupporter {
	
	public int[][]createBoard(int x);
	//creates a board of size [x+1][x+1], only fills up to [x] for col & row
	//the bottom of columns, the rightmost-hand side of rows and the bottom-right corner
	//is used to display the sum of columns, rows and the diagonal
	
	public boolean stillPlaying();
	

	public int[][]getBoard();
	//returns the board
	
	public String getValidUserInput();

	
	public void computerMove();

	public Object victorious();

}
