package caveExplorer;

public class WilliamSudokuDraft {
	
	public static void main(String[] args) {
		int[][] square = generateSquare(5);
		for(int i = 0; i < square[0].length; i++ ) {
			for(int j = 0; j < square[0].length; j++ ) {
				System.out.print(square[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static int[][] generateSquare(int size){
		int[][] x = new int [size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int check = (int)(Math.random()*10);
				while(rowContains(i,check,x) || colContains(i,check,x)){
					check = (int)(Math.random()*10);
				}
				x[i][j] = check;
			}
		}
		return x;
	}
	
	public static boolean rowContains(int row, int num, int[][] arr) {
		for (int i = 0; i < arr[i].length - 1; i ++) {
			if(arr[row][i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean colContains(int col, int num, int[][] arr) {
		for (int i = 0; i < arr[i].length - 1; i ++) {
			if(arr[i][col] == num) {
				return false;
			}
		}
		return true;
	}
	
	
}
