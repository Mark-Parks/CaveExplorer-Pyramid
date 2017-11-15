package caveExplorer;

import java.util.Scanner;

public class DevinFrontEnd implements TheoSupport {
	private DevinSupport backend;
	private boolean first;
	private int moves;
	private int matches;

	public static final void main(String args) {
		DevinFrontEnd demo = new DevinFrontEnd();
	}
	public DevinFrontEnd() {
		backend = new TheoBackEnd(this);
		moves = 32;
		matches = 0;
		first = false; // 1st tile to be clicked upon is flipped or not flipped
	}
	
	public void GameBegins() {
		/**
		 * make board, fill it with "." Each turned down card is a dot
		 * Each card will be assigned a letter randomly. Each letter will have a pair too.
		 * 4 by 4 board.
		 * while(!isGameOver){
		 * 		game 
		 * }
		 */
		TheoDevinPlot[][]plots = backend.getPlots();//w.e theo calls it
		TheoDevinPlot L = null;
		while(!backend.isGameOver()) {//when game is still playing or : while(moves > 0)
			displayBoard();
			showMatchNum();
			System.out.println("Where would you like to press?");
			TheoDevinPlot okdad = backend.getUserMove();
			checkMatch(okdad);
			//moves--;
		}
			printMsg(backend.GameoverMsg());	
	}	
	
	private void checkMatch(TheoDevinPlot okdad) {
		
		
	}
	public void rules() {
		
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
				//if(plots[row][col].isRevealed()){ supposed to be when card is flipped, make conditions with it in showMatchNum?
					//first = true; 
					//backend.SymbolsofCards(); reveals the value of cards
					//else if(backend.isMatch())
					//{ matches++;
					// first = false;		}

				

				}else{
					System.out.print(".");
				}
			}
			System.out.println(" " + rows.substring(row, row+1));
		}
		System.out.println(cols.substring(0, plots[0].length+2));
	//}
		
	//}
	public void printMsg(String msg){
		System.out.println(msg);
	}
}
