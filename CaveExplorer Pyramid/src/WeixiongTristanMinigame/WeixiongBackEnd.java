package WeixiongTristanMinigame;

public class WeixiongBackEnd implements TristanSupport{

	private WeixiongSupport frontend;
	private Block[][] maze;
	
	public WeixiongBackEnd(WeixiongSupport frontend) {
		this.frontend = frontend;
		this.maze = new Block[5][5];
	}

	public void createMaze() {
		
	}
}
