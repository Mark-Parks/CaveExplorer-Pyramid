package caveExplorer;

import java.util.Scanner;

public class TristanFrontEnd implements WeixiongSupport{
	
	private TristanSupport backend;
	private Scanner in;
	private Block[][] maze;
	//private static final int NORTH = 0;
	//private static final int EAST = 1;
	//private static final int SOUTH = 2;
	//private static final int WEST = 3;
	//private static final int[] DIRECTIONS = {NORTH, EAST, SOUTH, WEST};
	private static final String validInputs = "wdsac";
	
	public TristanFrontEnd() {
		backend = new WeixiongBackEnd(this);
		in = CaveExplorer.in;
	}

	public static void main(String[] args) {
		TristanFrontEnd demo = new TristanFrontEnd();
		demo.startPlaying();
		demo.play();
	}

	public void play() {
		String input = "";
		demo.backend.createMaze();
		this.maze = this.backend.getMaze();
		while(!backend.getGameCleared()) {
			drawMaze(maze);
			System.out.println("What's your next move?");
			input = in.nextLine();
			checkUserInput(input);
		}
		CaveExplorer.print("You have beaten the final challenge!");
		CaveExplorer.inventory.addKey();
		CaveExplorer.inventory.addArtifact(3);
	}
	
	public void startPlaying() {
		printIntro();
		//drawMaze(this.backend.getMaze());
	}
	
	public void printIntro() {
		System.out.println("You stupidly walk into the weird room as the door shuts behind you.");
		System.out.println("GUAHHHHHHHHHH");
		System.out.println("Oh good lord, get to the other side quickly!");
		System.out.println("(If a mummy is a space away from you, you will DIE)");
		System.out.println("Good luck solider!");
		System.out.println(" ");
	}

	public void drawMaze(Block[][] maze) {
		for(Block[] row: maze) {
			for(Block block: row) {
				System.out.print(block.getContents());
			}
			System.out.println(" ");
		}
	}

	public void printEndgameMsg() {
		System.out.println("And that's a WRAP. You've escaped from the mummies and proceed further on into the pyramid.");
	}


	public void checkUserInput(String input) {
		while(!isValid(input.toLowerCase())) {
			System.out.println("Please input w, a, s, d, or the cheat code.");
			input = in.nextLine();
		}
		if(input.toLowerCase().equals("c")) {
			printEndgameMsg();
			backend.setGameCleared(true);
		}
		else {
			move(toDirection(input));
		}
	}

	
	private boolean isValid(String input) {
		if(input.length() == 1) {
			for(int i = 0; i < validInputs.length(); i++) {
				if(validInputs.indexOf(input) > -1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int toDirection(String input) {
		return validInputs.indexOf(input);
	}
	
	public void move(int num) {
		int[] currentPosition = backend.getPlayerPosition();
		int xcoord = currentPosition[0];
		int ycoord = currentPosition[1];
		backend.getMaze()[xcoord][ycoord].leave();
		int[] offset = {-1, 1, 1, -1};
		if(num <= offset.length) {
			if(num % 2 == 0) {
				xcoord += offset[num];
			}
			else {
				ycoord += offset[num];
			}
			currentPosition[0] = xcoord;
			currentPosition[1] = ycoord;
			backend.move(currentPosition);
		}
		if(backend.checkWin()) {
			printEndgameMsg();
			backend.setGameCleared(true);
		}
		backend.moveMummy((int[]) backend.getMummy1Position());
		backend.moveMummy((int[]) backend.getMummy2Position());
	}
}
