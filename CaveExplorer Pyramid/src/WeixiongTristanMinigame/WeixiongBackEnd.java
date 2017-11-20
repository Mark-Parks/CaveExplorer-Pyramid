package WeixiongTristanMinigame;

public class WeixiongBackEnd implements TristanSupport{
	//constants
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	private static final int[] DIRECTIONS = {NORTH, EAST, SOUTH, WEST};

	private WeixiongSupport frontend;
	private boolean gameCleared;
	public Block[][] maze;
	private Block[][] initMaze;
	private int[] playerPosition;
	private int[][] mummies;
	private int[] mummy1Position;
	private int[] mummy2Position;
	
	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		this.gameCleared = false;
		this.maze = new Block[6][6];
		createMaze();
		this.playerPosition = new int[2];
		setStartingPosition();
	}
	
	public void clearGame() {
		gameCleared = true;
		frontend.printEndgameMsg();
	}
	
	public void move(int[] psn) {
		maze[playerPosition[0]][playerPosition[1]].setOccupied(true);
		maze[playerPosition[0]][playerPosition[1]].setContents(" ");
		playerPosition[0] = psn[0];
		playerPosition[1] = psn[1];
		maze[psn[0]][psn[1]].setOccupied(true);
		maze[psn[0]][psn[1]].setContents("X");
	}

	public void createMaze() {
		//populates the maze with roads
		for(Block[] row: maze) {
			for(Block col: row) {
				col = new Block();
			}
		}
		//adds walls; will decide layout later
		maze[0][2] = new VerticalWall();
		maze[1][2] = new VerticalWall();
		maze[1][3] = new HorizontalWall();
		maze[1][4] = new HorizontalWall();
		maze[1][5] = new HorizontalWall();
		//for resetting the game later, we set initMaze equal to maze
		this.initMaze = this.maze;
	}
	
	public void setStartingPosition() {
		playerPosition[0] = 0;
		playerPosition[1] = 0;
	}
	
	public void placeMummies() {
		//debating on whether or not to fix their paths, will decide later
		int xcoord;
		int ycoord;
		for(int[] mummy: mummies) {
			xcoord = (int)(Math.random() * maze.length);
			ycoord = (int)(Math.random() * maze[0].length);
			while(!maze[xcoord][ycoord].getContents().equals(" ")) {
				xcoord = (int)(Math.random() * maze.length);
				ycoord = (int)(Math.random() * 3) + 3;
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
		for(int i = 0;  i < DIRECTIONS.length; i++) {
			//looks in every direction for the player, will reset the game if player is found
			lookForPlayer(mummypsn, DIRECTIONS[i]);
		}
	}
	
	public void lookForPlayer(int[] mummypsn, int direction){
		if(containsPlayer(mummypsn, direction)) {
			resetBoard();
		}
	}
	
	public void resetBoard() {
		//resets the board with the mummies and player to their original starting positions
		this.maze = this.initMaze;
		setStartingPosition();
		placeMummies();
	}
	
	public boolean containsPlayer(int[] mummypsn, int direction) {
		int range = 1;
		int xcoord = mummypsn[0];
		int ycoord = mummypsn[1];
		if(direction % 2 == 0) {
			if(direction == NORTH && range > 0 && xcoord > 0) {
				while(range <=2 && xcoord > 0) {
					if(maze[xcoord - range][ycoord] instanceof VerticalWall || maze[xcoord - 1][ycoord] instanceof HorizontalWall) {
						return false;
					}
					else if(maze[xcoord - range][ycoord].containsPlayer){
						return true;
					}
					range++;
				}
			}
			else{
				while(range <= 2 && xcoord < maze.length - range) {
					if(maze[xcoord + range][ycoord] instanceof VerticalWall || maze[xcoord + 1][ycoord] instanceof HorizontalWall) {
						return false;
					}
					else if(maze[xcoord + range][ycoord].containsPlayer){
						return true;
					}
					range++;
				}
			}
		}
		else 
		{
			if(direction == EAST) {
				while(range <= 2 && ycoord > maze.length - 1) {
					if(maze[xcoord][ycoord + range] instanceof VerticalWall || maze[xcoord - 1][ycoord] instanceof HorizontalWall) {
						return false;
					}
					else if(maze[xcoord][ycoord + range].containsPlayer){
						return true;
					}
					range++;
				}
			}
			if(direction == WEST) {
				while(range <= 2 && ycoord > 0) {
					if(maze[xcoord][ycoord - range] instanceof VerticalWall || maze[xcoord - 1][ycoord] instanceof HorizontalWall) {
						return false;
					}
					else if(maze[xcoord][ycoord - range].containsPlayer){
						return true;
					}
					range++;
				}
			}
		}
		return false;
	}

	public int[][] checkValidMoves(int[] psn) {
		int[][] possiblePositions  = new int[4][2];
		int xcoord = psn[0];
		int ycoord = psn[1];
		//if a coordinate is an instance of a block but not a wall, then the mummy and player can move to it
		if(xcoord - 1 != 0) {
			possiblePositions[0][0] = xcoord - 1;
			possiblePositions[0][1] = ycoord;
		}
		else {
			possiblePositions[0] = null;
		}
		 
		if(xcoord + 1 < maze.length - 1) {
			possiblePositions[1][0] = xcoord + 1;
			possiblePositions[1][1] = ycoord;
		}
		else {
			possiblePositions[1] = null;
		}
		
		if(ycoord - 1 != 0) {
			possiblePositions[2][0] = xcoord;
			possiblePositions[2][1] = ycoord - 1;
		}
		else {
			possiblePositions[2] = null;
		}
		 
		if(ycoord + 1 < maze.length - 1) {
			possiblePositions[3][0] = xcoord;
			possiblePositions[3][1] = ycoord + 1;
		}
		else {
			possiblePositions[3] = null;
		}
		//still need to figure out what to do if the player and mummy both walk onto the same space
		return possiblePositions;
	}
	
	public String toCoords(int[] psn) {
		return "("+psn[0]+","+psn[1]+")";
	}

	public Block[][] getMaze(){
		return maze;
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
	
	public boolean getGameCleared() {
		return this.gameCleared;
	}
}
