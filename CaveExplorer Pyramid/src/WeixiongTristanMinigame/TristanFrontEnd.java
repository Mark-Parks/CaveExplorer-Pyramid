package WeixiongTristanMinigame;

public class TristanFrontEnd implements WeixiongSupport{
	
	private TristanSupport backend;

	public TristanFrontEnd() {
		backend = new WeixiongBackEnd(this);
	}

	public static void main(String[] args) {
		TristanFrontEnd demo = new TristanFrontEnd();
		demo.backend.createMaze();
		demo.drawMaze(demo.backend.getMaze());
		//demo.startPlaying();
		//demo.play();
	}

	public void play() {
		while(!backend.getGameCleared()) {
			
		}
		
	}

	public void startPlaying() {
		printIntro();
		Block[][] maze = backend.getMaze();
		System.out.println(maze);
		drawMaze(maze);
	}
	
	public void printIntro() {
		
	}

	public void drawMaze(Block[][] maze) {
		for(Block[] row: maze) {
			for(Block block: row) {
				System.out.print(block.getContents());
			}
			System.out.println("");
		}
	}

	public void printEndgameMsg() {
		System.out.println("Congratulations! You've escaped from the mummies! You proceed further on into the pyramid.");
	}


	public void checkUserInput(String input) {
		if(input.length() == 3) {
			try {
				
			}
			catch(Exception ex) {
				
			}
		}
		else {
			
		}
	}
}
