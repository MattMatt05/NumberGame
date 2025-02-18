package main.model;

// Game is responsible for both the actions and setup for the game.
public class Game {
    private int total;
    private int turn;
    private int playerMove;
    private String playerName;


    public Game() {
        total = (int) ((Math.random() * 11) + 20);
        turn = (int) (Math.random() * 3);
    }

    // MODIFIES: playerMove
    // EFFECTS: sets playerMove
    public void setPlayerMove(int playerMove) {
        this.playerMove = playerMove;
    }

    // EFFECTS: returns playerMove
    public int getPlayerMove() {
        return playerMove;
    }

    // EFFECTS: returns the number total
    public int getTotal() {
        return total;
    }

    // MODIFIES: total
    // EFFECTS: sets total
    public void setTotal(int total) {
        this.total = total;
    }

    // EFFECTS: computer chooses its next move
    public int computerTurn() {
        if ((total % 4) == 1) { // ex: 5
            return 1;
        } else if ((total % 4) == 2) { // ex: 6
            return 2;
        } else if ((total % 4) == 3) { // ex: 7
            return 3;
        } else {
            return (int) (Math.random() * 4);
        }
    }

    // EFFECTS: returns the name of the current player
    public String getCurrentTurn() {
        if (turn == 1) {
            return playerName;
        } else {
            return "CPU";
        }
    }
    
}