package game;


public class Player {
	private Grid playerGrid;
	private Grid shotGrid;
	private String name;
	
	public Player(String n) {
		playerGrid = new Grid();
		shotGrid = new Grid();
		name = n;
	}
	
	public boolean addNewShip(int column, int line, int s, int d) {
        boolean res=playerGrid.addNewShip(column, line, s, d);
        return res;
    }
	
	public boolean recordShot(int column, int line, Player p) {
		boolean suc = p.hasShip(column, line);
		shotGrid.addShot(column, line, suc);
		return suc;
	}	
	private boolean hasShip(int c, int l) {
        if(playerGrid.getValue(c,l)==1) {
            return true;
        }else {
            return false;
        }
    }
	
	public void initGridRandom() {
		 playerGrid.randomInit();
	}
	
	public void displayGrid() {
		System.out.println(playerGrid);
	}
	public void displayShotGrid() {
		System.out.println(shotGrid);
	}
	
	public boolean hasWin(){
        boolean res=false;
        int cpt = 0;
           for (int i = 0; i<Grid.getGridSize(); i++) {
               for (int j = 0; j<Grid.getGridSize(); j++) {
                   if(shotGrid.getValue(j, i)==1) {
                       cpt++;
                   }                    
               }
           }
           if(cpt == 18) {
             res =true;
          }
          return res;
   }
	
	public String getName() {
		return name;
	}
	
}
