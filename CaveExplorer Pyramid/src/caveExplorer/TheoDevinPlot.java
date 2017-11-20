package caveExplorer;

public class TheoDevinPlot {


	private boolean isUp;
	private String value;
	private int row;
	private int col;
	private boolean hasValue;
	public TheoDevinPlot(int row2, int col2) {
		this.row = row2;
		this.col = col2;
		hasValue = false;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public String getValue() {
		return value;
	}
	public boolean getUp() {
		return isUp;
	}
	public void setUp(boolean ok) {
		isUp = ok;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean hasValue() {
		return hasValue;
	}
	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}
	public boolean isRevealed() {
		// TODO Auto-generated method stub
		return false;
	}

}
