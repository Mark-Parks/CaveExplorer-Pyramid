package caveExplorer;

import java.util.Scanner;

public class DevinFrontEnd implements TheoSupport {
	private DevinSupport backend;
	private int moves;
	private int matches;
	

	public static final void main(String[] args) {
		DevinFrontEnd demo = new DevinFrontEnd();
		demo.gameBegins();
	}
	public DevinFrontEnd() {
		backend = new TheoBackEnd(this);
		moves = 24;
		matches = 0;
		CaveExplorer.in = new Scanner(System.in);
		//setFirst(false); // 1st tile to be clicked upon is flipped or not flipped
	}



	/*private void getUserMove(TheoDevinPlot plot1,TheoDevinPlot plot2) {
		if() {
			
		} else {
			System.out.println("That is not a valid tile!");
			CaveExplorer.in.nextLine();
		}
		if() {
			plots [backend.getCoordinput[0],backend.getCoordInput[1]] very important

		}
		else {
			System.out.println("You have clicked on the same tile!");
			CaveExplorer.in.nextLine();
		}
	}
	*/
	
	public void gameBegins() {

		rules();
		TheoDevinPlot[][]plots = backend.getPlots();//w.e theo calls it
		while(!backend.isGameOver()) {//when game is still playing or : while(moves > 0)
			displayBoard(plots);
			showMatchNum();
			showMoveNum();
			System.out.println("Where would you like to do?");
			TheoDevinPlot move1 = backend.getUserMove();
			while(move1.getUp()) {
				CaveExplorer.print("Pick a valid move");
				move1=backend.getUserMove();
			}
			move1.setUp(true);
			displayBoard(plots);
			TheoDevinPlot move2 = backend.getUserMove();
			while(move2.getUp()) {
				CaveExplorer.print("Pick a valid move");
				move2=backend.getUserMove();
			}
			move2.setUp(true);
			displayBoard(plots);
			if(backend.isMatch(move1,move2)) {
				matches++;
			}else {
				move1.setUp(false);
				move2.setUp(false);
			}
			moves--;
			CaveExplorer.print("");
		}
			CaveExplorer.print(backend.GameoverMsg());	
	}	
		
	

	public void rules() {
		System.out.println("You will have "+moves+" chances to find all the hieroglyphics."
				+ " To win, you must match all of the pairs of hieroglyphics together by inputting coordinates into the game.");
		
				
	}
	public void showMatchNum() {
		System.out.println(matches + " matches so far.");
	}
	public void showMoveNum() {
		System.out.println(moves + " moves left.");
	}
	public void displayBoard(TheoDevinPlot[][]plots) {
		String rows = "0123";
		String cols = "0123";
		for(int row = 0; row < plots.length; row++){
			System.out.print(rows.substring(row, row+1)+" ");
			for(int col = 0; col < plots[row].length; col++){
				if(plots[row][col].getUp()){ //supposed to be when card is flipped, make conditions with it in showMatchNum?
					
					System.out.print(plots[row][col].getValue()); //reveals the value of cards
				}else {
					System.out.print(".");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println("  "+cols.substring(0, plots[0].length)+" ");
	}
			
					

		
	

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getCol() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMoves() {
		// TODO Auto-generated method stub
		return moves;
	}
	@Override
	public int getMatches() {
		// TODO Auto-generated method stub
		return matches;
	}
}

