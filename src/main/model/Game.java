package main.model;

// Game is responsible for both the actions and setup for the game.
public class Game {
    private int total;
    private int turn;
    private int playerMove;
    private String playerName = "Player";

    public Game() {
        total = (int) ((Math.random() * 11) + 20);
        turn = (int) (Math.random() * 2)+1;
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

    // REQUIRES: an interger 1-2
    // MODIFIES: turn
    // EFFECTS: changes the turn
    public void setTurn(int turn) {
        this.turn = turn;
    }

    // EFFECTS: returns the number representing the current turn
    public int getTurn() {
        return turn;
    }

    // EFFECTS: computer chooses its next move
    public int computerTurn() {
        if ((total % 4) != 0) {
            return total % 4;
        } else {
            return (int) (Math.random() * 4);
        }
    }

    // MODIFIES: total
    // EFFECTS: substracts given amount from total
    public void move(int amount) {
        setTotal(total - amount);
    }
}