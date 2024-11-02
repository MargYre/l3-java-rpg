# Définit les variables
SRC_DIR = src
GAME_DIR = $(SRC_DIR)/game
SHOP_DIR = $(SRC_DIR)/shop
MAIN_CLASS = Main

# Cible par défaut
all: compile

# Compile tous les fichiers .java dans src, src/game, et src/shop
compile:
	javac $(SRC_DIR)/*.java $(GAME_DIR)/*.java $(SHOP_DIR)/*.java

# Exécute le programme principal
run: compile
	java -cp $(SRC_DIR) $(MAIN_CLASS)

# Nettoie tous les fichiers .class
clean:
	rm -f $(SRC_DIR)/*.class $(GAME_DIR)/*.class $(SHOP_DIR)/*.class

# Règle pour recompiler et exécuter
rebuild: clean all
