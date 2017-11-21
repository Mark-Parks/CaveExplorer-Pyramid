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
		System.out.println("You stupidly walk into the weird room as the door shuts behind you.");
		System.out.println("GUAHHHHHHHHHH");
		System.out.println("Oh good lord, get to the other side quickly!");
		System.out.println("(If a mummy is two spaces away from you, you will DIE)");
		System.out.println("Good luck solider!");
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
		System.out.println("And that's a WRAP. You've escaped from the mummies and proceed further on into the pyramid.");
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
