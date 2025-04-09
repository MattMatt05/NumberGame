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
        assertEquals(game.getTotal()-20, game.computerTurn());

        game.setTotal(22);
        assertEquals(game.getTotal()-20, game.computerTurn());

        game.setTotal(23);
        assertEquals(game.getTotal()-20, game.computerTurn());
    }

    @Test
    void testGettersAndSetters() {
        game.setPlayerMove(1);
        assertEquals(1, game.getPlayerMove());

        game.setTurn(1);
        assertNull(game.getTurn());

        game.setTurn(2);
        assertEquals("CPU", game.getTurn());
    }

    @Test
    void testMove() {
        
    }
}
