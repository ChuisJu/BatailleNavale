package game;

import java.util.ArrayList;

import javax.swing.JButton;

public class Grid {
	private static final int GRID_SIZE = 10;
	private int mat[][];

	public Grid() {
		mat = new int[GRID_SIZE][GRID_SIZE];
		initMat();
	}
	private void initMat() {
	}
	
	public void randomInit() {

	}
	
	public int getValue(int column, int line) {
		return 0;
	}
	
	public void addShot(int column, int line, boolean success) {
	}
	
	public boolean addNewShip(int column, int line, int s, int d) {
		return true;
	}
	
	private void placeShip (Coordinates coord, int size, int dir) {
	}
	
	private boolean isValidShip(Coordinates coord, int size, int dir) {
        return true;
	}

	public String toString(){
		
	
	        String [] lettre= {"   ","A","B","C","D","E","F","G","H","I","J"};

	        for(int a=0; a<11;a++) {
	            System.out.print(lettre[a]+" ");
	        }
	        System.out.println("\n   ---------------------\t");
	        for(int i=0; i<10;i++) {

	            System.out.print(i+" "+"| ");

	            for(int j=0;j<10;j++) {


	                System.out.print(mat[i][j]+" ");
	            }
	            System.out.print("|");
	            System.out.print("\n");
	        }
	        System.out.println("   ---------------------\t");
	        return "";
	    }
}
	

