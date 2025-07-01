JAVAC = javac
JAVA = java
SRCS = $(wildcard *.java)
BIN_DIR = bin
MAIN_CLASS = Cipher

all: compile

compile:
	$(JAVAC) -d . $(SRCS)  # Compiles directly into the current directory

clean:
	rm -rf $(BIN_DIR) *.class