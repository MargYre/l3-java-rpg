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
        shop.displayItems(); // Affiche les articles de la boutique
    }
}