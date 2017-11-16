package caveExplorer;

public class TheoBackEnd implements DevinSupport{

	private TheoSupport frontend;
	private TheoDevinPlot[][] plots;
	private int numMatch;
	private String[] values;
	
	public TheoBackEnd( TheoSupport frontend) {
		this.frontend = frontend;
		plots = new TheoDevinPlot[4][4];
		numMatch = 0;
		values = new String [16];
		values[0] = "A";
		values[1] = "A";
		values[2] = "B";
		values[3] = "B";
		values[4] = "C";
		values[5] = "C";
		values[6] = "D";
		values[7] = "D";
		values[8] = "E";
		values[9] = "E";
		values[10] = "F";
		values[11] = "F";
		values[12] = "G";
		values[13] = "G";
		values[14] = "H";
		values[15] = "H";
		
		createPlot();
	}
	public boolean isMoveValid() {
		if(frontend.getRow() > 3 || frontend.getRow() <0 || frontend.getCol() >3 || frontend.getCol() <0) {
			return false;
		}
		return true;
	}
	public boolean isGameOver() {
		if(frontend.getMatches() >=8 || frontend.getMoves()<0) {
			return true;
		}
		return false;
	}
	@Override
	public String GameoverMsg() {
		if(frontend.getMatches() >=8) {
		return "You win";
		}else {
			return "You lose";
		}
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
			for(int i =0; i<values.length;i++ ) {
				boolean placed = false;
					while(placed == false) {
						int z = (int)(Math.random() * plots.length);
						int y = (int)(Math.random() * plots[z].length);
						if(!plots[z][y].isHasValue()) {
							plots[z][y].setValue(values[i]);
							plots[z][y].setHasValue(true);
							placed = true;
						}
				}
			}
		}
	}
	                        
}
