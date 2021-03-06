package caveExplorer;

import java.lang.reflect.Array;
import java.util.Scanner;

public class WilliamFrontEnd implements MarkSupporter{

	private int[][] board;
	private WilliamSupporter backend;
	private boolean rewarded;
	private int sum;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
	}


	public WilliamFrontEnd() {
		backend = new MarkBackEnd(this);
		CaveExplorer.in = new Scanner(System.in);
		rewarded = false;
	}
	
	public boolean withinBounds(int num1, int num2, int num3, int num4, int size) {
		return num1 < size && num1 > -1 &&
				num2 < size && num2 > -1 &&
				num3 < size && num3 > -1 &&
				num4 < size && num4 > -1;
	}

	public void play(){
		System.out.println("");
		System.out.println("The carvings are, in truth, a strange sequence of symbols etched onto individual tiles on the sandstone walls.");
		System.out.println("You recognize them to be hieroglyphics. Fortunately, you can read them.");
		System.out.println("");
		
		board = backend.getBoard();
		backend.updateSums(board);
		displayBoard(board);
		
		System.out.println("");
        System.out.println("(The minigame is Magic Squares.");
        System.out.println("The four-by-four chunk of numbers on the top left is the 'board'.");
        System.out.println("The numbers underneath / to the side of the lines are the sums of the numbers in that row, column, or diagonal.");
        System.out.println("The goal is to make all of the sums equal to each other.");
        System.out.println("Enter coordinates in the form [row],[col] [row],[col] (eg; 0,0 1,2) to swap the numbers at those coordinates.");
        System.out.println("The top left number (" + board[0][0] + ") would be 0,0.");
        System.out.println("The number to the right (" + board[0][1] + ") of that would be 0,1)");
        System.out.print("");
        
        String input = CaveExplorer.in.nextLine();
        respondToInput(input);
        backend.updateSums(board);
        
	    while(!backend.victorious() && !input.equals("alohomora")){
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
					withinBounds(Integer.parseInt(input.substring(0,1)), 
							Integer.parseInt(input.substring(2,3)), 
							Integer.parseInt(input.substring(4,5)),
							Integer.parseInt(input.substring(6,7)),
							board[0].length - 1)){
				
				int a = Integer.parseInt(input.substring(0,1));
				int b = Integer.parseInt(input.substring(2,3));
				int c = Integer.parseInt(input.substring(4,5));
				int d = Integer.parseInt(input.substring(6,7));
				
				if(a == c && b == d) {
					System.out.println("You touch the same tile twice. Nothing happens.");
				}else {
					backend.swap(a,b,c,d,board);
					System.out.println("");
					System.out.println("The hieroglyphics on those tiles shift accordingly.");
				}
			}else {
				System.out.println("You try touching the tiles at the coordinates, but they are not a part of the puzzle. Nothing happens.");
			}
		}
		else {
			if(input.equals("alohomora")) {
				System.out.println("The puzzle falls apart beneaths your sorcery.");
			}else {
				System.out.println("Invalid input.");
			}
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
		System.out.println("Nothing else seems to happen though... You decide to try touching two more tiles.");
		while(!rewarded) {
			rewardSelect();
		}
	}
	
	public void rewardSelect() {
		String input = CaveExplorer.in.nextLine();
		if(input.length() == 7) {
			if(input.substring(1,2).equals(",") && input.substring(5,6).equals(",") &&
					withinBounds(Integer.parseInt(input.substring(0,1)), 
							Integer.parseInt(input.substring(2,3)), 
							Integer.parseInt(input.substring(4,5)),
							Integer.parseInt(input.substring(6,7)),
							board[0].length - 1)){
				
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
				
				for(int i = c - 1; i < c + 2; i++) {
					for(int j = d - 1; j < d + 2; j++) {
						if(i > -1 && j > -1 && i < board[0].length - 1 && j < board[0].length -1) {
							sum += board[i][j];
						}
					}
				}
				
				this.sum = sum;
			
				System.out.println("");
				System.out.println("The tiles slowly separate to reveal a golden statuette hidden behind the puzzle wall.");
				System.out.println("Your expertise in treasure hunting allows you to immediately appraise its value to be around " + sum + " thousand dollars.");
				System.out.println("You also seem to have found a few keys.");
				CaveExplorer.inventory.addKey();
				CaveExplorer.inventory.addKey();
				CaveExplorer.inventory.addKey();
				rewarded = true;
			}else {
				System.out.println("You try touching the tiles at the coordinates, but they are not a part of the puzzle. Nothing happens.");
			}
		}
		else {
			System.out.println("Invalid input. (enter in two tiles once more in the format [row],[col] [row],[col] this is to determine the reward)");
		}
	}

	public int getSum() {
		return sum;
	}
}
