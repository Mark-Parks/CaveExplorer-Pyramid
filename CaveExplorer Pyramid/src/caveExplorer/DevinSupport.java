package caveExplorer;

public interface DevinSupport {

	String GameoverMsg();

	TheoDevinPlot getUserMove();

	boolean isGameOver();

	boolean isMatch(TheoDevinPlot plot1,TheoDevinPlot plot2);

	TheoDevinPlot[][] getPlots();

	

}
