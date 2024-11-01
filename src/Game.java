import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel { //JPanel est une classe de base de Swing
    private Dungeon dungeon;
    private Player player;

    public Game() {
        player = new Player("Plop");
        dungeon = new Dungeon(10,10, player);

        setFocusable(true); //Permet de cliquer sur le panel
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        dungeon.movePlayer(0, -1);
                        break;
                    case KeyEvent.VK_DOWN:
                        dungeon.movePlayer(0, 1);
                        break;
                    case KeyEvent.VK_LEFT:
                        dungeon.movePlayer(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        dungeon.movePlayer(1, 0);
                        break;
                }
                repaint(); // Redessine le panneau
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dungeon.displayMap(); // Affiche la carte dans la console

        // Affiche la carte dans l'interface graphique
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                char cell = dungeon.getMap()[y][x];
                if (cell == 'P') {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(x * 30, y * 30, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(x * 30, y * 30, 30, 30);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dungeon Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(320, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
