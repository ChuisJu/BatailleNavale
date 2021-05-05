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
		return false;
	}
	
		public boolean recordShot(int column, int line, Player p) {
		boolean res=false;
		if(shotGrid.getValue(column, line)==0) {
			if(p.hasShip(column, line)==true) {
				shotGrid.addShot(column,line,true);
				res= true;
				
			}else{
				shotGrid.addShot(column,line,false);
				res= false;
			}
			
		}
		return res;
	}
	
	private boolean hasShip(int c, int l) {
		return false;
	}
	
	public void initGridRandom() {
	}
	
	public void displayGrid() {
		System.out.println(playerGrid);
	}
	public void displayShotGrid() {
		System.out.println(shotGrid);
	}
	
	public boolean hasWin(){
		return false;
	}
	
	public String getName() {
		return name;
	}
	
}
