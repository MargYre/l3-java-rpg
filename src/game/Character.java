// src/game/Character.java
package game;
import java.util.ArrayList;
import java.util.List;
import shop.Weapon;

public abstract class Character {
    protected int x;
    protected int y;
    protected String name;
    protected int health;
    protected Weapon equippedWeapon;
    protected List<String> inventory;

    public Character(String name, int health, int startX, int startY) {
        this.name = name;
        this.health = health;
        this.x = startX;
        this.y = startY;
        this.inventory = new ArrayList<>();
        this.equippedWeapon = null;
    }
    // Getters et setters de position
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
    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        System.out.println(name + " prend " + damage + " points de dégâts !");
        if (health <= 0) {
            die();
        }
    }
    public abstract int getAttackDamage();
    protected abstract void die();
    public boolean isAlive() {
        return health > 0;
    }
}