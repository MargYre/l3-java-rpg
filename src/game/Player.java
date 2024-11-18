//src/Player.java
package game;

import java.util.ArrayList;
import java.util.List;
import shop.Weapon;

public class Player extends Character {
    private int x;
    private int y;
    private String name;
    private int coins;
    private List<String> inventory;
    private Weapon equippedWeapon;

    //Constructeur
    public Player(String name) {
        super(name, 100, 0, 0); // Health, X, Y
        this.x = 0;
        this.y = 0;
        this.coins = 80;
        this.inventory = new ArrayList<>();
        this.equippedWeapon = null;
    }
    //Getters et setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    //Méthodes argent/boutique
    public void addCoins(int coins) {
        this.coins += coins;
    }
    public boolean canAfford(int amount) {
        return coins >= amount;
    }
    public void spendCoins(int amount) {
        if (canAfford(amount)) {
            coins -= amount;
        } else {
            notEnoughCoins();
        }
    }
    public void notEnoughCoins() {
        System.out.println("Vous n'avez pas assez de pièces.");
    }
    public void addItem(String item) {
        inventory.add(item);
        System.out.println(item + " a été ajouté à votre inventaire.");
    }
    public String showInventory() {
        StringBuilder sb = new StringBuilder("Inventaire :\n");
        for (String item : inventory) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }
    //pour le combat
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Vous avez équipé " + weapon.getName());
    }
    @Override
    public int getAttackDamage() {
        if (equippedWeapon == null) {
            return 1;  // Dégâts de base sans arme
        }
        return equippedWeapon.getDamage();
    }
    //pour le combat
    @Override
    protected void die() {
        System.out.println("Game Over! " + getName() + " est mort...");
    }
}
