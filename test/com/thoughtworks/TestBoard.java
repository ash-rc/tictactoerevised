package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ashleycampo on 6/21/14.
 */

public class TestBoard {
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDisplayBoard() {
        board.displayBoard();

        verify(printStream).println("   |   |   \n" +
                                    "---------\n" +
                                    "   |   |   \n" +
                                    "---------\n" +
                                    "   |   |   \n");
    }

    @Test
    public void shouldPlacePlayerMoveWhenPlayMoveCalled() {
        // might want to change this to verify that it calls display, or updates the array. Right now it's testing
        // two things. REFACTOR ASAP
        String playerSymbol = "x";
        int playerLocation = 0;
        board.placeMove(playerSymbol, playerLocation);

        verify(printStream).println(" x |   |   \n" +
                                    "---------\n" +
                                    "   |   |   \n" +
                                    "---------\n" +
                                    "   |   |   \n");

    }

    @Test
    public void shouldDisplayWarningWhenLocationTaken() {
        String playerOneSymbol = "x";
        String playerTwoSymbol = "o";
        int playerOneLocation = 1;


        board.placeMove(playerOneSymbol, playerOneLocation);
        board.placeMove(playerTwoSymbol, playerOneLocation);

        verify(printStream).println("   | x |   \n" +
                                    "---------\n" +
                                    "   |   |   \n" +
                                    "---------\n" +
                                    "   |   |   \n");
        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        // fill the board
        board.placeMove("x", 0);
        board.placeMove("o", 1);
        board.placeMove("x", 2);
        board.placeMove("o", 3);
        board.placeMove("x", 4);
        board.placeMove("o", 5);
        board.placeMove("x", 6);
        board.placeMove("o", 7);
        board.placeMove("x", 8);

    }
}
