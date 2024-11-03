//src/shop/Shop.java
package shop;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<ShopItem> items;

    public Shop() {
        this.items = new ArrayList<>();
        items.add(new ShopItem("Kit de Crochetage", 10)); // Exemple d'article
        items.add(new Axe("Axe", 50, 5));
    }

    public void displayItems() {
        System.out.println("Articles disponibles dans la boutique :");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + i + "] " + items.get(i));
        }
        System.out.println("Entrez un numéro pour acheter ou 'q' pour quitter.");
    }
    public ShopItem getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            return null;
        }
    }
    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index); // Supprime l'article de la liste
        }
    }
}