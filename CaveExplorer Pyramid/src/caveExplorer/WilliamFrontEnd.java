package caveExplorer;

import java.util.Scanner;

public class WilliamFrontEnd implements MarkSupporter{

	private int[][] board;
	private WilliamSupporter backend;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
	}


	public WilliamFrontEnd() {
		System.out.println("test1");
		backend = new MarkBackEnd(this);
		System.out.println("test1");
		CaveExplorer.in = new Scanner(System.in);
	}

	public void play(){
		System.out.println("You stumble upon a strange sequence of numbers.");
		System.out.println("test1");
		board = backend.getBoard();
		String input = CaveExplorer.in.nextLine();
	    while(backend.stillPlaying()){
	    	System.out.println("test2");
	    	System.out.println("test3");
	    	displayBoard(board);
	    	System.out.println("test4");
	        displayScore();
	        input = CaveExplorer.in.nextLine();
	        respondToInput(input);
	        analyzeBoard();
	        //
	        updateScore();
	    }
	        printGameOverMessage(backend.victorious());
	}
	
	private void printGameOverMessage(Object victorious) {
		// TODO Auto-generated method stub
		
	}


	private void updateScore() {
		// TODO Auto-generated method stub
		
	}


	private void analyzeBoard() {
		// TODO Auto-generated method stub
		
	}


	private void respondToInput(String input) {
		// TODO Auto-generated method stub
		
	}


	private void displayScore() {
		// TODO Auto-generated method stub
		
	}


	public void displayBoard(int[][] arr) {
		for(int i = 0; i < arr[0].length-1; i++) {
			for(int j = 0; j < arr[0].length-1; j++) {
				System.out.print("cry");
			}
			System.out.println("");
		}
	}


	@Override
	public String getValidUserInput() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}

}

