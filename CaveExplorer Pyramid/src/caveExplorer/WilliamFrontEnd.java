package caveExplorer;

public class WilliamFrontEnd implements MarkSupporter{

	
	private WilliamSupporter backend;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
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
	//
	
	public WilliamFrontEnd() {
		backend = new MarkBackEnd(this);
	}
}

