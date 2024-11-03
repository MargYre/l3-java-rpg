package game;
import java.util.Scanner;

import shop.Shop;
import shop.ShopInterac;

public class Game {
    private Player player;
    private Dungeon dungeon;
    private Shop shop;
    private ShopInterac shopInterac;
    private Scanner scanner;

    public Game(String playerName) {
        this.scanner = new Scanner(System.in);
        this.player = new Player(playerName);
        this.dungeon = new Dungeon(10, 10, player);
        this.shop = new Shop();
        this.shopInterac = new ShopInterac(shop, scanner);
    }

    public void start() {
        System.out.println("Bienvenue " + player.getName() + "! Essaye de sortir du donjon.");
        System.out.println("Pour vous déplacer dans le donjon, utilisez S (haut), W (gauche), X (bas), C (droite) pour vous déplacer.");
        System.out.println("Utilisez Q pour quitter et B pour accéder à la boutique, I pour afficher votre inventaire.");

        boolean gameRunning = true;

        while (gameRunning) {
            dungeon.displayMap();
            System.out.print("Entrez une commande (S/X/W/C/B/I/Q) : ");
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
                    shopInterac.openShop(player); // Accès à la boutique
                    break;
                case "I":
                    System.out.println(player.showInventory());
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