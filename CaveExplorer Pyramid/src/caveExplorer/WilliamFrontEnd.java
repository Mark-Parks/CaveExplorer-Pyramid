package caveExplorer;

public class WilliamFrontEnd implements MarkSupporter{

	
	private WilliamSupporter backend;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
	}


	public WilliamFrontEnd() {
		backend = new MarkBackEnd(this);
	}

	public void play(){
	    while(backend.stillPlaying()){
	        displayBoard();
	        displayScore();
	        String input = backend.getValidUserInput();
	        respondToInput(input);
	        backend.computerMove();
	        analyzeBoard();
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


	private void displayBoard() {
		// TODO Auto-generated method stub
		
	}

}

