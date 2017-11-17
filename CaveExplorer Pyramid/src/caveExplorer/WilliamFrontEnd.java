package caveExplorer;

import java.lang.reflect.Array;
import java.util.Scanner;

public class WilliamFrontEnd implements MarkSupporter{

	private int[][] board;
	private WilliamSupporter backend;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
	}


	public WilliamFrontEnd() {
		backend = new MarkBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
	}

	public void play(){
		System.out.println(" the sandstone tiles of the walls.");
		System.out.println("You notice a strange sequence of symbols etched on individual tiles on the sandstone walls.");
		board = backend.getBoard();
		backend.updateSums(board);
				
	    while(backend.stillPlaying()){
	        analyzeBoard();
	        updateScore();
	    	displayBoard(board);
	        displayScore();
	        String input = CaveExplorer.in.nextLine();
	        respondToInput(input);
	        backend.updateSums(board);
	    }
	    displayBoard(board);
	    System.out.println("The puzzle");
	}
	
	public void printGameOverMessage(Object victorious) {
		// TODO Auto-generated method stub
		
	}


	public void updateScore() {
		// TODO Auto-generated method stub
		
	}


	public void analyzeBoard() {
		
	}


	public void respondToInput(String input) {
		if(input.length() == 7) {
			System.out.println("length ok.");
			if(
			input.substring(1,2).equals(",") &&
			input.substring(5,6).equals(",")) {
				int a = Integer.parseInt(input.substring(0,1));
				int b = Integer.parseInt(input.substring(2,3));
				int c = Integer.parseInt(input.substring(4,5));
				int d = Integer.parseInt(input.substring(6,7));
				backend.swap(a,b,c,d,board);
				System.out.println("The numbers shift accordingly.");
			}
		}
		else {
			System.out.println("Error.");
		}
		
	}


	private void displayScore() {
		// TODO Auto-generated method stub
		
	}


	public void displayBoard(int[][] arr) {
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(j == 0 && i == 3) {
					System.out.println("");
					if(arr[i][j]<10) {
						System.out.print(arr[i][j] + "  ");
					}else {
						System.out.print(arr[i][j] + " ");
					}
				}
				else if(j == 2) {
					if(arr[i][j]<10) {
						System.out.print(arr[i][j] + "    ");
					}
					else {
						System.out.print(arr[i][j] + "   ");
					}
				}
				else if(arr[i][j]<10) {
					System.out.print(arr[i][j] + "  ");
				}else {
					System.out.print(arr[i][j] + " ");
				}
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

