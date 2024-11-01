# Définit les variables
SRC_DIR = src
CLASSES = $(SRC_DIR)/Dungeon.java $(SRC_DIR)/Game.java $(SRC_DIR)/Main.java $(SRC_DIR)/Player.java
MAIN_CLASS = Main

# Cible par défaut
all: compile

# Compile tous les fichiers .java
compile:
	javac $(CLASSES)

# Exécute le programme principal
run: compile
	java -cp $(SRC_DIR) $(MAIN_CLASS)

# Nettoie les fichiers .class
clean:
	rm -f $(SRC_DIR)/*.class

# Règle pour recompiler et exécuter
rebuild: clean all
