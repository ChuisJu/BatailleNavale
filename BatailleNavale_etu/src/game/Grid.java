
package game;

import java.util.ArrayList;

public class Grid {
	private static final int GRID_SIZE = 10;
	private int mat[][];
	
	public Grid() {
		mat = new int[GRID_SIZE][GRID_SIZE];
		initMat();
		
	}
	private void initMat() {
		for ( int j=0; j<mat.length; j++ ) {
			for ( int i=0; i<mat.length; i++ ) {
			    mat[i][j] = 0;
			}
		}	
	}
	
	public void randomInit() {

	}
	
    public int getValue(int column, int line) {
        int j = 0;
        int i = 0;
        boolean boucle = true;
        for (i=0; boucle && i<10; i++) {
            for (j=0; j<10; j++) {
                if(i == column && j == line) {
                    if(mat[i][j]==1) {
                        i = column;
                        j = line;
                        boucle = false;
                    }
                }
            }
        }
        return mat[i][j];
    }
	
	public void addShot(int column, int line, boolean success) {

	}
	
	public boolean addNewShip(int column, int line, int s, int d) {
		return true;
	}
	
	private void placeShip (Coordinates coord, int size, int dir) {
        int column=coord.getColumn();
        int line=coord.getLine();
        mat[line][column]=1;
        if(dir==1) {
            for(int i=0; i<size; i++) {
                mat[line][column+i]=1;
            }

        }else if(dir==0){
            for(int i=0; i<size; i++) {
                mat[line+i][column]=1;
            }
        }
    }
	
	
	private boolean isValidShip(Coordinates coord, int size, int dir) {
        boolean res = false;
        int column=coord.getColumn();
        int line=coord.getLine();
        if(dir==1) {
            int limite=column+size;
            if(limite>GRID_SIZE) {
                res=false;
            }else {
                res=true;
                for(int i=0; i<size; i++) {
                    int place = mat[line][column+i];
                    if(place==1) {
                        res = false;
                    }
                }
            }


        }else if(dir==0){
            int limite=line+size;
            if(limite>GRID_SIZE) {
                res=false;
            }else {
                res=true;
                for(int i=0; i<size; i++) {
                    int place = mat[line+i][column];
                    if(place==1) {
                        res = false;
                    }
                }
            }

        }

        System.out.println(res);
        return res;
    }
	
	public String toString(){
		String [] lettre= {"   ","A","B","C","D","E","F","G","H","I","J"};

        for(int a=0; a<11;a++) {
            System.out.print(lettre[a]+" ");
        }
        System.out.println("\n   ---------------------\t");
        for(int i=0; i<10;i++) {
            System.out.print(i+" | ");
            for(int j=0;j<10;j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
        System.out.println("   ---------------------");
        return "";
    }
}
