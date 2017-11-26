package caveExplorer;

public interface TristanSupport {
	//makes the backend interpretation of the maze
	void createMaze();
	//gets maze from backend
	Block[][] getMaze();
	boolean getGameCleared();
	
	int[] getPlayerPosition();
	
	void move(int[] currentPosition);
	void moveMummies();
	boolean checkWin();
	void setGameCleared(boolean b);
	
}
