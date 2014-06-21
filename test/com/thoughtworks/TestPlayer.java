package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by ashleycampo on 6/21/14.
 */
public class TestPlayer {
    private BufferedReader reader;
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        playerOne = new Player(reader, "x", board, 1);
        playerTwo = new Player(reader, "o", board, 2);
    }

    @Test
    public void shouldPlaceXWhenPlayerOnePlays() throws IOException {
        String symbol = "x";
        int move = 1;

        when(reader.readLine()).thenReturn(Integer.toString(move));
        playerOne.getMove();

        verify(board).placeMove(symbol, move - 1);
    }

    @Test
    public void shouldPlaceOWhenPlayerTwoPlays() throws IOException {
        String symbol = "o";
        int move = 3;

        when(reader.readLine()).thenReturn(Integer.toString(move));
        playerTwo.getMove();

        verify(board).placeMove(symbol, move-1);
    }

    @Test
    public void shouldRequestMoveAgainWhenLocationTaken() throws IOException {
        int move = 1;
        when(reader.readLine()).thenReturn(Integer.toString(move)).thenReturn(Integer.toString(move)).thenReturn(Integer.toString(move+1));

        playerOne.getMove();
        playerTwo.getMove();

        verify(reader, atLeast(2)).readLine();
    }






}