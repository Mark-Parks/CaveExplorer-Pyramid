package WeixiongTristanMinigame;

import caveExplorer.CaveExplorer;

public class WeixiongBackEnd implements TristanSupport{

	private WeixiongSupport frontend;
	private boolean gameCleared;
	public Block[][] maze;
	private boolean isAlive;
	private int[] playerPosition;
	private int[][] mummies;
	private int[] mummy1Position;

	private int[] mummy2Position;
	
	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		this.gameCleared = false;
		this.maze = new Block[10][10];
		this.isAlive = true;
		this.playerPosition = new int[2];
		setStartingPosition();
		placeMummys();
	}

	public void createMaze() {
		//populates the maze with roads
		for(Block[] row: maze) {
			for(Block col: row) {
				col = new Block();
			}
		}
		//adds walls; will decide layout later
	}
	
	public void setStartingPosition() {
		playerPosition[0] = 0;
		playerPosition[1] = 0;
	}
	
	public void placeMummys() {
		int xcoord;
		int ycoord;
		for(int[] mummy: mummies) {
			xcoord = (int)(Math.random() * maze.length);
			ycoord = (int)(Math.random() * maze[0].length);
			while(!maze[xcoord][ycoord].getContents().equals(" ")) {
				xcoord = (int)(Math.random() * maze.length);
				ycoord = (int)(Math.random() * 3)+3;
			}
			mummy[0] = xcoord;
			mummy[1] = ycoord;
		}
	}
	
	public void moveMummy(int[] mummypsn) {
		//moves the mummies; will only be called if the player makes a valid move
		int[][] validPositions = checkValidMoves(mummypsn);
		int idx = (int)(Math.random() * validPositions.length);
		while(validPositions[idx] == null) {
			idx = (int)(Math.random() * validPositions.length);
		}
		mummypsn = validPositions[idx];
		lookForPlayer(mummypsn);
	}
	
	public void lookForPlayer(int[] mummypsn){
		if(containsPlayer(mummypsn, north){
			
		}	
	}
	
	public int[][] checkValidMoves(int[] psn) {
		int[][] possiblePositions  = new int[8][2];
		int xcoord = psn[0];
		int ycoord = psn[1];
		
		return possiblePositions;
	}

	public Block[][] getMaze(){
		return this.maze;
	}
	
	public int[] getPlayerPosition() {
		return playerPosition;
	}

	public int[] getMummy1Position() {
		return mummy1Position;
	}

	public int[] getMummy2Position() {
		return mummy2Position;
	}
}
