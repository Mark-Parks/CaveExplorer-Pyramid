package caveExplorer;

public class TheoBackEnd implements DevinSupport{

	private TheoSupport frontend;
	private int numMatch;
	
	public TheoBackEnd( TheoSupport frontend) {
		this.frontend = frontend;
		numMatch = 0;
	}
}
