package shop;

public class Weapon extends ShopItem {
    private int damage;

    public Weapon(String name, int price, int damage) {
        super(name, price);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return super.toString() + " - Dégâts : " + damage;
    }
}