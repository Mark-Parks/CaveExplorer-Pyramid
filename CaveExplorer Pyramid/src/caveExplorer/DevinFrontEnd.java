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
		moves = 32;
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
		/**
		 * make board, fill it with "." Each turned down card is a dot
		 * Each card will be assigned a letter randomly. Each letter will have a pair too.
		 * 4 by 4 board.
		 * while(!isGameOver){
		 * 		game 
		 * }
		 */
		rules();
		TheoDevinPlot[][]plots = backend.getPlots();//w.e theo calls it
		//TheoDevinPlot L = null;
		while(!backend.isGameOver()) {//when game is still playing or : while(moves > 0)
			displayBoard(plots);
			showMatchNum();
			System.out.println("Where would you like to press?");
			TheoDevinPlot move1 = backend.getUserMove();
			TheoDevinPlot move2 = backend.getUserMove();
			backend.isMatch(move1,move2);
			//moves--;
		}
			printMsg(backend.GameoverMsg());	
	}	
	

	public void rules() {
		System.out.println("You will have "+moves+" chances to find all the matches."
				+ " To win, you must match 2 of the same cards together by inputting coordinates into the game."
				);
	}
	public void showMatchNum() {
		System.out.println(matches);
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
		System.out.println(cols.substring(0, plots[0].length+2));
	}
			
					

		
	
	/*public void printMsg(String msg){
		//not needed?
	}
	*/
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

