package caveExplorer;

public class DevinFrontEnd implements TheoSupport {
	private DevinSupport backend;
	private boolean first;
	private int moves;

	public static final void main(String args) {
		DevinFrontEnd demo = new DevinFrontEnd();
	}
	public DevinFrontEnd() {
		backend = new TheoBackEnd(this);
		moves = 32;
		first = false;
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
		while(!backend.isGameOver()) {//when game is still playing {
			displayBoard();
			showMatchNum();
			TheoDevinPlot okdad = backend.getUserMove();
			checkMatch(okdad);
		}
			printMsg(backend.GameoverMsg());	
	}	
	
	private void checkMatch(TheoDevinPlot okdad) {
		
		
	}
	public void rules() {
		
	}
	public void showMatchNum() {
		
	}
	public void displayBoard() {
		
	}
	public void printMsg(String msg){
		
	}
}
