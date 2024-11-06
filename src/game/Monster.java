package game;

public class Monster extends Character {
    private int goldValue;
    private char symbol;

    public Monster(String name, int maxHealth, int goldValue, int x, int y, char symbol) {
        super(name, maxHealth, x, y);
        this.goldValue = goldValue;
        this.symbol = symbol;
    }

    public int getGoldValue() {
        return goldValue;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public int getAttackDamage() {
        return 9;  // Le monstre a des dégâts fixes
    }
    @Override
    protected void die() {
        System.out.println(getName() + " a été vaincu ! Vous récupéré " + goldValue + " pièces d'or.");
    }
}