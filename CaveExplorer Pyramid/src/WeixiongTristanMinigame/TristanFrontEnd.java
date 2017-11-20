package WeixiongTristanMinigame;

public class TristanFrontEnd implements WeixiongSupport{
	
	private TristanSupport backend;

	public TristanFrontEnd() {
		backend = new WeixiongBackEnd(this);
	}

	public static void main(String[] args) {
		TristanFrontEnd demo = new TristanFrontEnd();
		demo.startPlaying();
	}

	public void startPlaying() {
		printIntro();
		drawMaze(backend.getMaze());
	}
	
	public void printIntro() {
		
	}

	public void drawMaze(Block[][] maze) {
		for(Block[] row: maze) {
			for(Block block : row) {
				System.out.print(block.getContents());
			}
			System.out.println("");
		}
	}

	public void printEndgameMsg() {
		System.out.println("Congratulations! You've escaped from the mummies");
	}
}
