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
    WinChecker winChecker;

    @Before
    public void setUp() {
        board = mock(Board.class);
        winChecker = new WinChecker();
    }

    @Test
    public void shouldCallBoardWhenVerifyingHorizontalWins() {
        List<Integer> horizontalCombination = new LinkedList<Integer>();
        horizontalCombination.add(0);
        horizontalCombination.add(1);
        horizontalCombination.add(2);
        String symbol = "x";
        winChecker.verifyHorizontalWin(symbol);

        verify(board).verifyWin(horizontalCombination, symbol);
    }
}
