public class Player {
    private int x;
    private int y;
    private String name;
    private int coins;

    //Constructeur
    public Player(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.coins = 80;
    }
    //Getters et setters
    public int getX() {
        return x;dungeon.displayMap();
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
    public void notEnoughCoins() {
        System.out.println("Vous n'avez pas assez de pièces.");
    }
}
