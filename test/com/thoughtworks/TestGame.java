package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;

/**
 * Created by ashleycampo on 6/21/14.
 */
public class TestGame {
    BufferedReader reader;
    PrintStream printStream;
    Board board;
    Player playerOne;
    Player playerTwo;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
    }

    @Test
    public void shouldPlayGameUntilBoardIsFull() {
        
    }

    @Test
    public void shouldReturnResultWhenGameFinished() {

    }
}
