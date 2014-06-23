package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Game {
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public static void main(String[] args) throws IOException {
        Game game = setUpGame();
	    game.playGame();
    }

    public void playGame() throws IOException {
        Player currentPlayer = playerOne;
        board.displayBoard();
        while(!board.isFull() && !board.isWinner(playerOne.getSymbol()) || !board.isWinner(playerTwo.getSymbol())) {
            currentPlayer.getMove();
            currentPlayer = currentPlayer.getOpponent();
        }

        board.displayResult();
    }

    public static Game setUpGame() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        String[] boardArray = new String[9];
        Arrays.fill(boardArray, " ");
        Board board = new Board(printStream, boardArray);
        Player playerOne = new Player(reader, "x", board, printStream, 1);
        Player playerTwo = new Player(reader, "o", board, printStream, 2);
        playerOne.setOpponent(playerTwo);
        playerTwo.setOpponent(playerOne);

        return new Game(board, playerOne, playerTwo);
    }
}
