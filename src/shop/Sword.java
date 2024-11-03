// src/shop/Sword.java
package shop;

public class Sword extends Weapon {
    public Sword(String name, int price, int damage) {
        super(name, price, damage);
    }
    @Override
    public int getDamage() {
        return super.getDamage();
    }
    @Override
    public String toString() {
        return super.toString() + " - Dégâts : " + getDamage();
    }
}