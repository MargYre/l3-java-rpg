import java.util.ArrayList;

public class Player {
    private int x;
    private int y;
    private String name;
    private int coins;
    private ArrayList<Weapon> inventory;

    //Constructeur
    public Player(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.coins = 80;
        this.inventory = new ArrayList<>();
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

    //Méthodes
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
    //armes
    public void addWeapon(Weapon weapon) {
        inventory.add(weapon);
        System.out.println(weapon.getName() + " a été ajouté à votre inventaire.");
    }
    public String showInventory() {
        StringBuilder s = new StringBuilder("Inventaire :\n");
        for (Weapon w : inventory) {
            s.append("- ").append(w.toString()).append("\n");
        }
        return s.toString();
    }
}
