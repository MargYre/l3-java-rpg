package game;

public class CombatSystem {
    public void initiateCombat(Character attacker, Character defender) {
        if (!(attacker instanceof Player) || !(defender instanceof Monster)) {
            System.out.println("Combat invalide!");
            return;
        }

        Player player = (Player) attacker;
        Monster monster = (Monster) defender;

        System.out.println("\n********* COMBAT *********");
        System.out.println(player.getName() + " VS " + monster.getName());

        // Boucle de combat
        while (true) {
            // Tour du joueur
            System.out.println("\n" + player.getName() + " attaque!");
            monster.takeDamage(player.getAttackDamage());
            
            // Vérifier si le monstre est mort
            if (!monster.isAlive()) {
                System.out.println("Vous avez vaincu le monstre!");
                handleMonsterDefeat(player, monster);
                break;
            }

            // Tour du monstre
            System.out.println("\nLe monstre contre-attaque!");
            player.takeDamage(monster.getAttackDamage());
            
            // Vérifier si le joueur est mort
            if (!player.isAlive()) {
                System.out.println("Game Over! Vous avez été vaincu...");
                System.exit(0);
            }
        }
    }

    private void handleMonsterDefeat(Player player, Monster monster) {
        int gold = monster.getGoldValue();
        player.addCoins(gold);
        System.out.println("Vous gagnez " + gold + " pièces d'or!");
    }
}