package main.ui;

import javax.swing.*;

// The purpose of this class is to serve as a GUI for the Number Game
public class GameGUI {
    private JFrame window;

    public GameGUI() {
        window = new JFrame();

        windowSetup();
    }

    // MODIFIES: window
    // EFFECTS: sets up a visible window
    private void windowSetup() {
        window.setTitle("Number Game");
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
