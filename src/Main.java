//src/Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre nom : ");
        String playerName = scanner.nextLine();
        // Lancer le jeu
        Game game = new Game(playerName);
        game.start();
        scanner.close();
    }
}
