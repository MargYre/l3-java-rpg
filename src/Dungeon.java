public class Dungeon {
    private char[][] map;
    private int width;
    private int height;
    private Player player;

    // Getter
    public char[][] getMap() {
        return map;
    }
    public Dungeon(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.map = new char[height][width];
        this.player = player;
        initializeMap();
    }
    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.'; // Cases vides
            }
        }
        map[player.getY()][player.getX()] = 'P';
    }
    public void displayMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void movePlayer(int X, int Y) {
        map[player.getY()][player.getX()] = '.';

        int newX = player.getX() + X;
        int newY = player.getY() + Y;

        if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
            player.setX(newX);
            player.setY(newY);
        }
        map[player.getY()][player.getX()] = 'P';
    }
}
