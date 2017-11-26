package caveExplorer;

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
	
	//TEST CODE
	public static void main(String[] args) {
		int[] test = {1,1};
		WeixiongBackEnd test1 = new WeixiongBackEnd(null);
		test1.createMaze();
		test1.move(test);
		test1.printMaze(test1.maze);
		/*int[][] test3 = test1.checkValidMoves(test);
		for(int[] psn: test3) {
			System.out.println(test1.toCoords(psn));
		}*/
		//test1.resetBoard();
		test1.printMaze(test1.maze);
		test1.lookForPlayer(test, WEST);
	}

	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		this.gameCleared = false;
		mummies = new int[2][2];
		mummy1Position = new int[2];
		mummy2Position = new int[2];
		mummy1Position[0] = -1;
		mummy1Position[1] = -1;
		mummy2Position[0] = -1;
		mummy2Position[1] = -1;
		mummies[0] = mummy1Position;
		mummies[1] = mummy2Position;
		this.maze = new Block[6][6];
		this.playerPosition = new int[2];
	}
	
	public void clearGame() {
		gameCleared = true;
		frontend.printEndgameMsg();
	}
	
	public void move(int[] psn) {
		if(psn[0] >=0 && psn[0] < maze.length && psn[1] >= 0 && psn[1] < maze.length) {
			maze[playerPosition[0]][playerPosition[1]].leave();
			if(getMaze()[psn[0]][psn[1]] instanceof HorizontalWall || getMaze()[psn[0]][psn[1]] instanceof VerticalWall) {
				runIntoWall();
			}
			else {
				playerPosition[0] = psn[0];
				playerPosition[1] = psn[1];
				maze[psn[0]][psn[1]].enter();
			}
		}
		else {
			runIntoWall();
		}
	}
	
	public void runIntoWall() {
		System.out.println("Oh no, you ran right into a wall! The mummies are sure\nto come after you now.\n");
		resetBoard();
	}

	public void moveMummies() {
		for(int[] mummy: mummies) {
			moveMummy(mummy);
		}
	}
	
	public boolean checkWin() {
		return playerPosition[0] == maze.length - 1 && playerPosition[1] == maze.length - 1;
	}

	public void createMaze() {
		//populates maze with Blocks, then replaces certain elements with Walls
		//n.b. not sure why it doesn't work with the for each loop will lab it later
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				maze[i][j] = new Block();
			}
		}	
		maze[0][2] = new VerticalWall();
		maze[1][2] = new VerticalWall();
		maze[2][0] = new HorizontalWall();
		maze[2][3] = new HorizontalWall();
		maze[3][4] = new HorizontalWall();
		maze[4][5] = new HorizontalWall();
		setStartingPosition();
		placeMummies();
		
		this.initMaze = this.maze;
	}
	
	//test code
	public void printMaze(Block[][] maze) {
		for(Block[] row: maze) {
			for(Block block: row) {
				System.out.print(block.getContents());
			}
			System.out.println("");
		}
	}
	
	public void resetBoard() {
		//resets the board with the mummies and player to their original starting positions
		for(int i = 0; i < initMaze.length; i++) {
			for(int j = 0; j < initMaze[i].length; j++) {
				maze[i][j] = initMaze[i][j];
				if(!(maze[i][j] instanceof VerticalWall) && !(maze[i][j] instanceof HorizontalWall)) {
					maze[i][j].leave();
				}
			}
		}
		setStartingPosition();
		placeMummies();
		System.out.println("Oh no! A mummy spotted you and hit your head! \nEverything goes black... \nYou wake up back at the start of the cave...\n");
	}

	public void setStartingPosition() {
		playerPosition[0] = 0;
		playerPosition[1] = 0;
		maze[0][0].enter();
	}
	
	public void placeMummies() {
		//debating on whether or not to fix their paths, will decide later
		int xcoord;
		int ycoord;
		for(int[] mummy: mummies) {
			xcoord = (int)(Math.random() * maze.length);
			ycoord = (int)(Math.random() * maze[0].length);
			while(!maze[xcoord][ycoord].getContents().equals("   ") | (xcoord == 0 && ycoord < 3)) {
				xcoord = (int)(Math.random() * maze.length);
				ycoord = (int)(Math.random() * 3) + 3;
			}
			mummy[0] = xcoord;
			mummy[1] = ycoord;
			maze[mummy[0]][mummy[1]].enterMummy();
		}
	}
	
	public void moveMummy(int[] mummypsn) {
		//moves the mummies; will only be called if the player makes a valid move
		for(int i = 0;  i < DIRECTIONS.length; i++) {
			//looks in every direction for the player, will reset the game if player is found
			lookForPlayer(mummypsn, DIRECTIONS[i]);
		}
		int[][] validPositions = checkValidMoves(mummypsn);
		int idx = (int)(Math.random() * validPositions.length);
		while(validPositions[idx] == null || maze[validPositions[idx][0]][validPositions[idx][1]].containsMummy()) {
			idx = (int)(Math.random() * validPositions.length);
		}
		maze[mummypsn[0]][mummypsn[1]].leaveMummy();
		mummypsn[0] = validPositions[idx][0];
		mummypsn[1] = validPositions[idx][1];
		maze[mummypsn[0]][mummypsn[1]].enterMummy();
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
	
	public boolean containsPlayer(int[] mummypsn, int direction) {
		int range = 1;
		int xcoord = mummypsn[0];
		int ycoord = mummypsn[1];
		if(direction % 2 == 0) {
			if(direction == NORTH && xcoord - 1 > 0) {
				while(range <= 1 && xcoord > 0) {
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
				while(range <= 1 && xcoord < maze.length - range) {
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
				while(range <= 1 && ycoord > maze.length - 1)
					try {
						if(maze[xcoord][ycoord + range] instanceof VerticalWall || maze[xcoord - 1][ycoord] instanceof HorizontalWall) {
							return false;
						}
						else if(maze[xcoord][ycoord + range].containsPlayer){
							return true;
						}
						range++;
					}
					catch(Exception ex) {
						
					}
				}
			}
			if(direction == WEST) {
				while(range <= 1 && ycoord - 1 > 0) {
					try {
						if(maze[xcoord][ycoord - range] instanceof VerticalWall || maze[xcoord - 1][ycoord] instanceof HorizontalWall) {
							return false;
						}
						else if(maze[xcoord][ycoord - range].containsPlayer){
							return true;
						}
						range++;
					}
					catch(Exception ex) {
						return false;
					}
				}
			}
		return false;
	}

	public int[][] checkValidMoves(int[] psn) {
		int[][] possiblePositions = new int[4][2];
		int xcoord = psn[0];
		int ycoord = psn[1];
		//if a coordinate is an instance of a block but not a wall, then the mummy and player can move to it
		if(xcoord - 1 >= 0 && !(maze[xcoord - 1][ycoord] instanceof HorizontalWall) && !(maze[xcoord - 1][ycoord] instanceof VerticalWall)) {
			possiblePositions[0][0] = xcoord - 1;
			possiblePositions[0][1] = ycoord;
		}
		else {
			possiblePositions[0] = null;
		}
		//ignore the debug statements
		//System.out.println(possiblePositions[0][0]+","+possiblePositions[0][1]);
		 
		if(xcoord + 1 < maze.length - 1 && !(maze[xcoord + 1][ycoord] instanceof HorizontalWall) && !(maze[xcoord + 1][ycoord] instanceof VerticalWall)) {
			possiblePositions[1][0] = xcoord + 1;
			possiblePositions[1][1] = ycoord;
		}
		else {
			possiblePositions[1] = null;
		}
		
		//System.out.println(possiblePositions[1][0]+","+possiblePositions[1][1]);
		
		if(ycoord - 1 >= 0 && !(maze[xcoord][ycoord - 1] instanceof HorizontalWall) && !(maze[xcoord][ycoord - 1] instanceof VerticalWall)) {
			possiblePositions[2][0] = xcoord;
			possiblePositions[2][1] = ycoord - 1;
		}
		else {
			possiblePositions[2] = null;
		}
		
		//System.out.println(possiblePositions[2][0]+","+possiblePositions[2][1]);
		 
		if(ycoord + 1 < maze.length - 1 && !(maze[xcoord][ycoord + 1] instanceof HorizontalWall) && !(maze[xcoord][ycoord + 1] instanceof VerticalWall)) {
			possiblePositions[3][0] = xcoord;
			possiblePositions[3][1] = ycoord + 1;
		}
		else {
			possiblePositions[3] = null;
		}
		
		//System.out.println(possiblePositions[3][0]+","+possiblePositions[3][1]);

		//still need to figure out what to do if the player and mummy both walk onto the same space
		return possiblePositions;
	}
	
	public String toCoords(int[] psn) {
		return "("+psn[0]+","+psn[1]+")";
	}

	public Block[][] getMaze(){
		return maze;
	}
	
	public void setGameCleared(boolean x) {
		this.gameCleared = x;
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
