//src/shop/Shop.java
package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<String> items;

    public Shop() {
        this.items = new ArrayList<>();
        items.add("Kit de Crochetage - 15 pièces"); // Exemple d'article
    }

    public void displayItems() {
        System.out.println("Articles disponibles dans la boutique :");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + i + "] " + items.get(i));
        }
    }
}