import java.util.Scanner;

public class Game {
    private Player player;
    private Dungeon dungeon;
    private Scanner scanner;

    public Game(String playerName) {
        this.scanner = new Scanner(System.in);
        this.player = new Player(playerName);
        this.dungeon = new Dungeon(10, 10, player);
    }

    public void start() {
        System.out.println("Bienvenue " + player.getName() + "! Essaye de sortir du donjon.");
        System.out.println("Pour vous déplacer dans le donjon, utilisez S (haut), W (gauche), X (bas), C (droite) pour vous déplacer.");
        System.out.println("Utilisez Q pour quitter et B pour accéder à la boutique.");

        boolean gameRunning = true;

        while (gameRunning) {
            System.out.print("Entrez une commande (S/X/W/C/B/Q) : ");
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
                    System.out.println("Boutique non encore implémentée.");
                    //shopInteraction.openShop(player); // Accès à la boutique
                    break;
                case "Q":
                    gameRunning = false;
                    System.out.println("Vous avez quitté le donjon.");
                    break;
                default:
                    System.out.println("Commande invalide !");
            }
        }

        scanner.close();
    }
}