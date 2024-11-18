package game;
public class Dungeon {
    private char[][] map;
    private int width;
    private int height;
    private Player player;
    private Monster monster;
    private CombatSystem combat;

    // Getter
    public char[][] getMap() {
        return map;
    }
    public Dungeon(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.map = new char[height][width];
        this.player = player;
        //this.monster = new Monster("Monstre", 50, 20, 8, 5, 'M');
        this.monster = new Monster("Monstre", 39, 20, 2, 1, 'M');
        this.combat = new CombatSystem();
        initializeMap();
    }
    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.';
            }
        }
        map[player.getY()][player.getX()] = 'P';
        map[4][9] = '_'; 
        map[6][9] = '_';
        map[5][9] = 'E';
        map[monster.getY()][monster.getX()] = monster.getSymbol();
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
            if (map[newY][newX] == '_') {
                map[player.getY()][player.getX()] = 'P';
                return;
            }
            if (map[newY][newX] == 'M') {
                combat.initiateCombat(player, monster);
                if (!monster.isAlive()) {
                    map[monster.getY()][monster.getX()] = '.';
                }
                map[player.getY()][player.getX()] = 'P';
                return;
            }
            if (map[newY][newX] == 'E') {
                System.out.println("Vous avez trouvé la sortie !");
                System.exit(0);;
            }
            player.setX(newX);
            player.setY(newY);
        }
        map[player.getY()][player.getX()] = 'P';
    }

    /*private void fight() {
        System.out.println("\n*** COMBAT ***");
        System.out.println("Vous attaquez !");
        monster.takeDamage(player.getAttackDamage());
        if (monster.isAlive()) {
            System.out.println("Le monstre contre-attaque !");
            player.takeDamage(5);
            if (!player.isAlive()) {
                System.out.println("Vous avez été vaincu... Pensez à acheter une arme la prochaine fois.");
                System.exit(0);
            }
        }else {
            System.out.println("Vous avez vaincu le monstre !");
            map[monster.getY()][monster.getX()] = '.';
        }
    }*/
}