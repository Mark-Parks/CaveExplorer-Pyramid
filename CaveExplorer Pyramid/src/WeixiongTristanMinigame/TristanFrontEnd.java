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
		drawMaze(backend.getMaze());
	}
	
	public void drawMaze(Block[][] maze) {
		for(Block[] row: maze) {
			for(Block block : row) {
				System.out.print(block.getContents());
			}
			System.out.println("");
		}
	}
}
