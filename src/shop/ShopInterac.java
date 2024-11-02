//src/shop/ShopInterac.java
package shop;
import java.util.Scanner;

import game.Player;

public class ShopInterac {
    private Shop shop;
    private Scanner scanner;

    public ShopInterac(Shop shop, Scanner scanner) {
        this.shop = shop;
        this.scanner = scanner;
    }

    public void openShop(Player player) {
        System.out.println("Bienvenue dans la boutique !");
        boolean shopping = true;
        while (shopping) {
            shop.displayItems();
            System.out.print("Votre choix : ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                shopping = false; // Quitter la boutique
                System.out.println("Vous avez quitté la boutique.");
            } 
        }

    }
}