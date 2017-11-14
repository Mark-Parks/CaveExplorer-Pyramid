package caveExplorer;

public class TheoBackEnd implements DevinSupport{

	private TheoSupport frontend;
	private TheoDevinPlot[][] plots;
	private int numMatch;
	
	public TheoBackEnd( TheoSupport frontend) {
		this.frontend = frontend;
		plots = new TheoDevinPlot[4][4];
		numMatch = 0;
		createPlot();
	}
	public boolean isMoveValid() {
		return false;
	}
	public boolean isGameOver() {
		return false;
	}
	@Override
	public String GameoverMsg() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TheoDevinPlot getUserMove() {
		// TODO Auto-generated method stub
		return null;
	}
	private void createPlot() {
		for(int row = 0; row<plots.length;row++) {
			for(int col =0;col<plots[row].length;col++) {
				plots[row][col]= new TheoDevinPlot(row,col);
			}
			//add values to each plot
		}
	}
	                        
}
