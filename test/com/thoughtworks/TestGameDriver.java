package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ashleycampo on 6/23/14.
 */
public class TestGameDriver {
    Board board;
    GameDriver gameDriver;

    @Before
    public void setUp() {
        board = mock(Board.class);
        gameDriver = new GameDriver();
    }

    @Test
    public void shouldCallBoardWhenVerifyingHorizontalWins() {
        List<Integer> horizontalCombination = new LinkedList<Integer>();
        horizontalCombination.add(0);
        horizontalCombination.add(1);
        horizontalCombination.add(2);
        String symbol = "x";
        gameDriver.verifyHorizontalWin(symbol);

        verify(board).verifyWin(horizontalCombination, symbol);
    }
}
