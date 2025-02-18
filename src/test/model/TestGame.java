package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import main.model.Game;

public class TestGame {
    private Game game;
    
    @BeforeEach
    void runBefore() {
        game = new Game();
    }

    @Test
    void testComputerTurn() {
        game.setTotal(21);
        assertEquals(1, game.computerTurn());

        game.setTotal(22);
        assertEquals(2, game.computerTurn());

        game.setTotal(23);
        assertEquals(3, game.computerTurn());
    }
}
