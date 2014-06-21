package com.thoughtworks;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by ashleycampo on 6/21/14.
 */
public class Board {
    private PrintStream out;
    private String[] board = new String[9];

    public Board(PrintStream out) {
        this.out = out;
        initializeBoard();
    }

    public void displayBoard() {
        out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " \n" +
                    "---------\n" +
                    " " + board[3] + " | " + board[4] + " | " + board[5] + " \n" +
                    "---------\n" +
                    " " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    public boolean placeMove(String symbol, int move) {
        if (moveValid(move)) {
            updateBoardArray(symbol, move);
            displayBoard();
            return true;
        }
        displayCollisionError();
        return false;
    }

    private void updateBoardArray(String symbol, int move) {
        board[move] = symbol;
    }

    private void initializeBoard() {
        Arrays.fill(board, " ");
    }

    private boolean moveValid(int move) {
        if(board[move] == " ") {
            return true;
        }
        return false;
    }

    private void displayCollisionError() {
        out.println("Location already taken");
    }
}
