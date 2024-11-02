//src/Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pour vous déplacer dans le donjon, utilisez S (haut), W (gauche), X (bas), C (droite) pour vous déplacer.");
        System.out.println("Utilisez Q pour quitter et B pour accéder à la boutique.");
        System.out.println("Entrez votre nom : ");
        String playerName = scanner.nextLine();
        System.out.println("Bienvenue " + playerName + "! Essaye de sortir du donjon.");
        Player player = new Player(playerName);
        Dungeon dungeon = new Dungeon(10, 10, player);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.print("Entrez une commande (S/X/W/C ou Q) : ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "S":
                    dungeon.movePlayer(0, -1); // Haut
                    dungeon.displayMap();
                    break;
                case "X":
                    dungeon.movePlayer(0, 1); // Bas
                    dungeon.displayMap();
                    break;
                case "W":
                    dungeon.movePlayer(-1, 0); // Gauche
                    dungeon.displayMap();
                    break;
                case "C":
                    dungeon.movePlayer(1, 0); // Droite
                    dungeon.displayMap();
                    break;
                case "B":
                    System.out.println("Vous êtes dans la boutique.");
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
