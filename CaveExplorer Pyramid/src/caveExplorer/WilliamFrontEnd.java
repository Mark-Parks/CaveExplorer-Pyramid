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
		System.out.println("The carvings are, in truth, a strange sequence of symbols etched onto individual tiles on the sandstone walls.");
		System.out.println("You recognize them to be hieroglyphics. Fortunately, you can read them.");
		System.out.println("");
		board = backend.getBoard();
		backend.updateSums(board);
		displayBoard(board);
        String input = CaveExplorer.in.nextLine();
        
	    while(backend.stillPlaying() && !input.equals("dab")){
	    	System.out.println("");
	    	displayBoard(board);
	        input = CaveExplorer.in.nextLine();
	        respondToInput(input);
	        backend.updateSums(board);
	    }
	    displayBoard(board);
	    reward();
	    //need to make reward so that it asks again if they enter invalid input
	    System.out.println("As you solve the puzzle, the ground trembles. Maybe a new passageway has opened?");
	}

	public void respondToInput(String input) {
		if(input.length() == 7) {
			if(input.substring(1,2).equals(",") && input.substring(5,6).equals(",") &&
				(Integer.parseInt(input.substring(0,1)) < board[0].length - 1) && 
				(Integer.parseInt(input.substring(2,3)) < board[0].length - 1) &&
				(Integer.parseInt(input.substring(4,5)) < board[0].length - 1) &&
				(Integer.parseInt(input.substring(6,7)) < board[0].length - 1) &&
				
				(Integer.parseInt(input.substring(0,1)) > -1) && 
				(Integer.parseInt(input.substring(2,3)) > -1) &&
				(Integer.parseInt(input.substring(4,5)) > -1) &&
				(Integer.parseInt(input.substring(6,7)) > -1)){
				
				int a = Integer.parseInt(input.substring(0,1));
				int b = Integer.parseInt(input.substring(2,3));
				int c = Integer.parseInt(input.substring(4,5));
				int d = Integer.parseInt(input.substring(6,7));
				backend.swap(a,b,c,d,board);
				System.out.println("");
				System.out.println("The numbers shift accordingly.");
			}else {
				System.out.println("You try touching the tiles at the coordinates, but they are not a part of the puzzle. Nothing happens.");
			}
		}
		else {
			System.out.println("Invalid input.");
		}
	}

	public void displayBoard(int[][] arr) {
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(j == 0 && i == arr[0].length-1) {
					System.out.println("_____________|__ ");
					if(arr[i][j]<10) {
						System.out.print(arr[i][j] + "  ");
					}else {
						System.out.print(arr[i][j] + " ");
					}
				}
				else if(j == arr[0].length-2) {
					if(arr[i][j]<10) {
						System.out.print(arr[i][j] + "   |");
					}
					else {
						System.out.print(arr[i][j] + "  |");
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
	
	public void reward() {
		System.out.println("As the numbers align, you hear a clicking sound as unseen mechanisms lock into place.");
		System.out.println("Nothing else seems to happen though... You decide to try swapping two more tiles.");
		String input = CaveExplorer.in.nextLine();
		if(input.length() == 7) {
			if(input.substring(1,2).equals(",") && input.substring(5,6).equals(",") &&
				(Integer.parseInt(input.substring(0,1)) < board[0].length - 1) && 
				(Integer.parseInt(input.substring(2,3)) < board[0].length - 1) &&
				(Integer.parseInt(input.substring(4,5)) < board[0].length - 1) &&
				(Integer.parseInt(input.substring(6,7)) < board[0].length - 1) &&
				
				(Integer.parseInt(input.substring(0,1)) > -1) && 
				(Integer.parseInt(input.substring(2,3)) > -1) &&
				(Integer.parseInt(input.substring(4,5)) > -1) &&
				(Integer.parseInt(input.substring(6,7)) > -1)){
				
				int sum = 0;
				
				int a = Integer.parseInt(input.substring(0,1));
				int b = Integer.parseInt(input.substring(2,3));
				int c = Integer.parseInt(input.substring(4,5));
				int d = Integer.parseInt(input.substring(6,7));
				
				for(int i = a - 1; i < a + 2; i++) {
					for(int j = b - 1; j < b + 2; j++) {
						if(i > -1 && j > -1 && i < board[0].length - 1 && j < board[0].length -1) {
							sum += board[i][j];
						}
					}
				}
				
				for(int i = a - 1; i < a + 2; i++) {
					for(int j = b - 1; j < b + 2; j++) {
						if(i > -1 && j > -1 && i < board[0].length - 1 && j < board[0].length -1) {
							sum += board[i][j];
						}
					}
				}
				
				System.out.println("");
				System.out.print("The tiles slowly separate to reveal an artifact hidden in the wall.");
			}else {
				System.out.println("You try touching the tiles at the coordinates, but they are not a part of the puzzle. Nothing happens.");
			}
		}
		else {
			System.out.println("Invalid input.");
		}
	}




}

