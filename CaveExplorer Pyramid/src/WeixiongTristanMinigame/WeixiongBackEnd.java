package WeixiongTristanMinigame;

public class WeixiongBackEnd implements TristanSupport{

	private WeixiongSupport frontend;
	public Block[][] maze;
	private boolean isAlive;
	private int[] playerPosition;
	private int[][] mummies;
	private int[] mummy1Position;
	private int[] mummy2Position;
	
	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		this.maze = new Block[5][5];
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
	
	public void moveMummies() {
		//moves the mummies; will only be called if the player makes a valid move
		int[][] validPositions = checkValidMoves();
	}
	
	
	
	private int[][] checkValidMoves() {
		int[][] positions;
		return positions;
	}

	public Block[][] getMaze(){
		return this.maze;
	}
}
