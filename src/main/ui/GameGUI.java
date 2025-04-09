package main.ui;

import main.model.Game;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.fail;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

// The purpose of this class is to serve as a GUI for the Number Game
public class GameGUI {
    private JFrame window;
    private JPanel display;
    private JPanel moves;
    private GridBagConstraints displayAlign;
    private Game game;
    private JLabel total;
    private JLabel turn;
    private String winner;

    public GameGUI() {
        window = new JFrame();
        display = new JPanel();
        moves = new JPanel();
        game = new Game();

        setupGBC();
        windowSetup();
        displaySetup();
    }

    // MODIFIES: window
    // EFFECTS: sets up a visible window
    private void windowSetup() {
        window.setTitle("Number Game");
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        JPanel temp = new JPanel();
        temp.setBackground(Color.decode("#0E3B43"));
        window.add(temp, BorderLayout.EAST);
        temp = new JPanel();
        temp.setBackground(Color.decode("#0E3B43"));
        window.add(temp, BorderLayout.SOUTH);
        temp = new JPanel();
        temp.setBackground(Color.decode("#0E3B43"));
        window.add(temp, BorderLayout.NORTH);
        temp = new JPanel();
        temp.setBackground(Color.decode("#0E3B43"));
        window.add(temp, BorderLayout.WEST);
    }

    // EFFECTS: establishes GridBagConstraints
    private void setupGBC() {
        displayAlign = new GridBagConstraints();
        displayAlign.gridx = 0;
        displayAlign.anchor = GridBagConstraints.CENTER;
        displayAlign.ipady = 10;
    }

    // EFFECTS: sets up display panel for window
    private void displaySetup() {
        JPanel movesHolder = new JPanel();
        display.setBackground(Color.decode("#A3BBAD"));
        JLabel title = new JLabel("Number Game");
        if (game.getTurn() == 2) {
            turn = new JLabel("CPU");
            moves.setVisible(false);
        } else {
            turn = new JLabel("Player");
        }
        total = new JLabel(Integer.toString(game.getTotal()));

        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        turn.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        total.setFont(new Font(Font.SERIF, Font.BOLD, 40));

        display.setLayout(new GridBagLayout());
        display.add(title, displayAlign);
        display.add(turn, displayAlign);
        display.add(total, displayAlign);
        movesSetup();
        movesHolder.setPreferredSize(new Dimension(200, 50));
        movesHolder.setBackground(Color.decode("#A3BBAD"));
        movesHolder.add(moves);
        display.add(movesHolder, displayAlign);
        window.add(display);

        startGameLoop();
    }

    // MODIFIES: display
    // EFFECTS: winning screen. This is displayed when a person has won.
    private void winningScreen() {
        display.removeAll();
        if (game.getTurn() == 1) {
            winner = "CPU";
        } else {
            winner = "Player";
        }

        display.setBackground(Color.decode("#A3BBAD"));

        JLabel title = new JLabel("The " + winner + " has won!");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 30));

        display.add(title, displayAlign);
        display.revalidate();
        display.repaint();
    }

    // EFFECTS: sets up game loop for taking turns
    private void startGameLoop() {
        Timer gameLoop = new Timer(100, e -> {
            if (game.getTotal() <= 0) {
                ((Timer) e.getSource()).stop();
                try {
                    Thread.sleep(2500);
                    winningScreen();
                } catch (InterruptedException a) {
                    Thread.currentThread().interrupt();
                }
            }
            if (game.getTurn() == 1) {
                moves.setVisible(true);
            } else {
                computerTurn();
            }
        });
        gameLoop.start();
    }

    // EFFECTS: sets up move options for player
    private void movesSetup() {
        for (int i = 1; i <= 3; i++) {
            Button button = new Button("-" + i);
            final int remove = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    game.move(remove);
                    total.setText(Integer.toString(game.getTotal()));
                    turn.setText("CPU");
                    game.setTurn(2);
                    moves.setVisible(false);
                }
            });
            button.setBackground(Color.decode("#A3BBAD"));
            button.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            moves.add(button);
        }
        moves.setBackground(Color.decode("#A3BBAD"));
    }

    // EFFECTS: the computer determines and sets its next move
    private void computerTurn() {
        try {
            total.setText(Integer.toString(game.getTotal()) + " - " + game.computerTurn());
            Thread.sleep(2500);
            game.move(game.computerTurn());
            total.setText(Integer.toString(game.getTotal()));
            game.setTurn(1);
            turn.setText("Player");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
