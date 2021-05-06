package game;

import java.util.Scanner;

public class Game {
	private static Player player1;
	private static Player player2;
	private static Scanner scan = new Scanner(System.in);
	private static Player robot;
	private static Player currentPlayer;
	private static Player opponent;
	private static int mode = 1; //1 player, 2 players

	private static void fakeInitPlayerGrid(Player p) {
		p.addNewShip(0,0, 5, 0);
		p.addNewShip(5,3, 4, 1);
		p.addNewShip(9,6, 3, 0);
		p.addNewShip(2,9, 2, 1);
		p.addNewShip(1,0, 2, 0);
		p.addNewShip(8,0, 1, 0);
		p.addNewShip(8,4, 1, 0);
	}

	private static void initPlayerGrid(Player p) {

		int c,l,dir;
		boolean added;
		int ships[] = {5, 4, 3, 2, 2, 1, 1};

		int i = 0;
		String str;
		do {
			p.displayGrid();
			System.out.println("\tPlacer bateau --------> taille " + ships[i] + " : ");
			System.out.println("Entrez la coordonnÃ©e : ");
			str = scan.nextLine();
			if(str.length()<2) continue;
			c=str.charAt(0)-65;
			l=Integer.parseInt(str.substring(1, 2));
			System.out.println("Entrez la direction (0: vert, 1:horiz) : ");
			dir=Integer.parseInt(scan.nextLine());

			added = p.addNewShip(c,l, ships[i], dir);
			if(added) {
				i++;
			}else {
				System.out.println("Placement du bateau de taille " + ships[i] + " en " + c + "," + l + " impossible.");
			}
		}while(i<ships.length);
		
		System.out.println("Votre grille est complÃ¨te.");
		p.displayGrid();

	}

	public static void launch2players() {
		mode = 2;
		player1 = new Player("Joueur1");
		player2 = new Player("Joueur2");
		currentPlayer = player1;
		opponent = player2;
		initGame();

	}

	public static void launch1player() {
		mode = 1;
		player1 = new Player("Joueur1");
		robot = new Player("Robot");
		currentPlayer = player1;
		opponent = robot;
		initGame();
	}
	private static void initGame() {
		System.out.println(player1.getName()+", remplissez votre grille.\n");
		fakeInitPlayerGrid(player1);
		//initPlayerGrid(player1);

		System.out.println("Appuyez sur entrÃ©e pour changer de joueur.");
		scan.nextLine();
		hideGame();

		if(mode==2) {
			System.out.println(player2.getName()+", remplissez votre grille.\n");
			fakeInitPlayerGrid(player2);
			//initPlayerGrid(player2);

		}else {
			robot.initGridRandom();
			System.out.println("La grille de " + robot.getName()+" est remplie.\n");
		}
		
		System.out.println("Appuyez sur entrÃ©e pour commencer la partie.");
		scan.nextLine();
		hideGame();
	}
	public static boolean shot() {
		System.out.println(currentPlayer.getName() + ", entrez une coordonnÃ©e Ã  attaquer.\n");
		currentPlayer.displayShotGrid();
		String str = scan.nextLine();
		int c=str.charAt(0)-65;
		//System.out.println(c);
		int l=Integer.parseInt(str.substring(1, 2));
		boolean replay = currentPlayer.recordShot(c, l, opponent);
		
		return replay;

	}
	public static void changeCurrentPlayer() {
		Player tmp = currentPlayer;
		currentPlayer = opponent;
		opponent = tmp;
		System.out.println("Appuyez sur entrÃ©e pour changer de joueur.");
		scan.nextLine();
		hideGame();
	}
	
	private static void hideGame() {
		int i;
		for(i=0; i<40; i++) {
			System.out.println();
		}
	}
	public static boolean isOver() {
		boolean over = currentPlayer.hasWin() || opponent.hasWin();

		return over; 
	}

}
