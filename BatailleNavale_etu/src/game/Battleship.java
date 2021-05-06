package game;

public class Battleship {
    public static void main(String[] args) {
        boolean replay;
        Game.launch2players();
        do {
            replay = Game.shot();
            if(!replay) {
                System.out.println("Raté !");
                Game.changeCurrentPlayer();
            }else if (!Game.isOver()){
                System.out.println("Touché ! Vous pouvez rejouer.");
            }
            else {
                System.out.println("Touché !");
            }
        }while(!Game.isOver());
        System.out.println("Partie terminée ! Merci d'avoir joué !");
    }
}
