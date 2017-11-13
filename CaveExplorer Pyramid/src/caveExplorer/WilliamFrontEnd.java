package caveExplorer;

public class WilliamFrontEnd implements MarkSupporter{

	
	private WilliamSupporter backend;
	
	public static final void main(String[] args) {
		WilliamFrontEnd demo = new WilliamFrontEnd();
		demo.play();
	}

	private void play() {
		// TODO Auto-generated method stub
		
	}
	public WilliamFrontEnd() {
		backend = new MarkBackEnd(this);
	}
}

