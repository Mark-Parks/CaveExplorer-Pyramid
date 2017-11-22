package caveExplorer;

import java.util.Scanner;

public class TristanFrontEnd implements WeixiongSupport{
	
	private TristanSupport backend;
	private Scanner in;
	
	public TristanFrontEnd() {
		backend = new WeixiongBackEnd(this);
		in = CaveExplorer.in;
	}

	public static void main(String[] args) {
		TristanFrontEnd demo = new TristanFrontEnd();
		demo.backend.createMaze();
		demo.startPlaying();
		demo.play();
	}

	public void play() {
		String input;
		while(!backend.getGameCleared()) {
			System.out.println("What's your next move?");
			input = in.nextLine();
			checkUserInput(input);
		}
		
	}
	
	public void startPlaying() {
		printIntro();
		drawMaze(this.backend.getMaze());
	}
	
	public void printIntro() {
		System.out.println("You stupidly walk into the weird room as the door shuts behind you.");
		System.out.println("GUAHHHHHHHHHH");
		System.out.println("Oh good lord, get to the other side quickly!");
		System.out.println("(If a mummy is two spaces away from you, you will DIE)");
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
		while(!isValid(input)) {
			System.out.println("Please input w, a, s, d, or the cheat code.");
			input = in.nextLine();
		}
	}

	private boolean isValid(String input) {
		// TODO Auto-generated method stub
		return false;
	}
}
