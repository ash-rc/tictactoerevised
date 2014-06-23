package com.thoughtworks;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ashleycampo on 6/21/14.
 */
public class Board {
    private PrintStream out;
    private String[] board = new String[9];

    public Board(PrintStream out, String[] board) {
        this.out = out;
        this.board = board;
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
        return board[move] == " ";
    }

    private void displayCollisionError() {
        out.println("Location already taken");
    }

    public boolean isFull() {
        for(String symbol : board) {
            if(symbol == " ") {
                return false;
            }
        }
        return true;
    }

    public void displayResult() {
        if(isWinner("x")) {
            out.println("Player 1 Wins!");
        } else if (isWinner("o")) {
            out.println("Player 2 Wins!");
        }
        out.println("Game is a draw");
    }

    public boolean isWinner(String symbol) {
        return checkHorizontal(symbol) || checkVertical(symbol);
    }

    private boolean checkHorizontal(String symbol) {
        int adjustRow = 0;
        while(adjustRow <= 6) {
            if(board[0 + adjustRow].equals(symbol) && board[1+adjustRow].equals(symbol) && board[2 + adjustRow].equals(symbol)) {
                return true;
            }
            adjustRow += 3;
        }
        return false;
    }

    private boolean checkVertical(String symbol) {
        int adjustRow = 0;
        while(adjustRow <= 2) {
            if(board[0 + adjustRow].equals(symbol) && board[3 + adjustRow].equals(symbol) && board[6 + adjustRow].equals(symbol)) {
                return true;
            }
            adjustRow++;
        }
        return false;
    }

    public boolean verifyWin(List<Integer> combination, String symbol) {
        for(int combinations: combination) {
            if (board[combinations] != symbol) {
                return false;
            }
        }
        return true;
    }
}
