// src/shop/Arrow.java
package shop;

public class Arrow extends Weapon {
    private int range;
    public Arrow(String name, int price, int damage, int range) {
        super(name, price, damage);
        this.range = range;
    }
    public int getRange() {
        return range;
    }
    @Override
    public String toString() {
        return super.toString() + " - Portée : " + range;
    }
}