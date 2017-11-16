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
	
	public void startPlaying() {
		System.out.println("As you walk into the room, you find yourself in the middle of a huge maze. In it ");
		System.out.println("you find 2 mummies prowling the area. If you could walk through, you could probably get ");
		System.out.println("more places in the pyramid");
		System.out.println(x); //directions on how to play
		String repsonse = CaveExplorer.in.nextLine();
		while()
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
	
	public void moveMummies() {
		//moves the mummies; will only be called if the player makes a valid move
		int[][] validPositions = checkValidMoves();
	}
	
	private int[][] checkValidMoves() {
		int[][] positions = new int[8][1];
		int[][] mummyPositions = {this.mummy1Position, this.mummy2Position};
		if()
		return positions;
	}

	public Block[][] getMaze(){
		return this.maze;
	}
}
