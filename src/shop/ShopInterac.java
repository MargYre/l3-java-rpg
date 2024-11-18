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
        System.out.println("Bienvenue dans la boutique ! (Entrez 'q' pour quitter)");
        boolean shopping = true;
        while (shopping) {
            System.out.println("Vous avez " + player.getCoins() + " pièces.");
            shop.displayItems();
            System.out.print("Votre choix : ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                shopping = false;
                System.out.println("Vous avez quitté la boutique.");
            } else {
                try {
                    int index = Integer.parseInt(choice);
                    ShopItem item = shop.getItem(index);

                    if (item != null) {
                        if (player.canAfford(item.getPrice())) {
                            player.spendCoins(item.getPrice());
                            player.addItem(item.getName());
                            if (item instanceof Weapon) {
                                player.equipWeapon((Weapon) item);
                                System.out.println(" **Vous avez acheté et équipé : " + item.getName() + "**");
                            } else {
                                System.out.println(" **Vous avez acheté : " + item.getName() + "**");
                            }
                            shop.removeItem(index);
                        } else {
                            System.out.println("Vous n'avez pas assez de pièces pour acheter " + item.getName() + ".");
                        }
                    } else {
                        System.out.println("Numéro d'article invalide.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Choix invalide.");
                }
            }
        }

    }
}