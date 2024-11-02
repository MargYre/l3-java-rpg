# Définit les variables
SRC_DIR = src
# CLASSES = $(SRC_DIR)/*.java  Compile tous les fichiers Java dans src
MAIN_CLASS = Main

# Cible par défaut
all: compile

# Compile tous les fichiers .java
compile:
	javac $(SRC_DIR)/**/*.java $(SRC_DIR)/*.java

# Exécute le programme principal
run: compile
	java -cp $(SRC_DIR) $(MAIN_CLASS)

# Nettoie les fichiers .class
clean:
	rm -f $(SRC_DIR)/*.class

# Règle pour recompiler et exécuter
rebuild: clean all
