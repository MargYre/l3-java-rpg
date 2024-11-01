//src/Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Plop");
        Dungeon dungeon = new Dungeon(10, 10, player);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Amusez vous à vous déplacer dans le donjon ! Utilisez S (haut), W (gauche), X (bas), C (droite) pour vous déplacer. Q pour quitter.");
        
        boolean gameRunning = true;

        while (gameRunning) {
            dungeon.displayMap();
            System.out.print("Entrez une commande (S/X/W/C ou Q) : ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "S":
                    dungeon.movePlayer(0, -1); // Haut
                    break;
                case "X":
                    dungeon.movePlayer(0, 1); // Bas
                    break;
                case "W":
                    dungeon.movePlayer(-1, 0); // Gauche
                    break;
                case "C":
                    dungeon.movePlayer(1, 0); // Droite
                    break;
                case "Q":
                    gameRunning = false;
                    System.out.println("Vous avez quitté le donjon.");
                    break;
                default:
                    System.out.println("Utilisez W, A, S, D ou Q.");
            }
        }

        scanner.close();
    }
}
