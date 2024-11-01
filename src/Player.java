public class Player {
    private int x;
    private int y;
    private String name;

    //Constructeur
    public Player(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
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
}
