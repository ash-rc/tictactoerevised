package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        Player playerOne = new Player(reader, "x", board, System.out, 1);
        Player playerTwo = new Player(reader, "o", board, System.out, 2);
        playerOne.setOpponent(playerTwo);
        playerTwo.setOpponent(playerOne);

        Game game = new Game(board, playerOne, playerTwo);
	    game.playGame();
    }

    public void playGame() throws IOException {
        Player currentPlayer = playerOne;
        board.displayBoard();
        while(!board.isFull()) {
            currentPlayer.getMove();
            currentPlayer = currentPlayer.getOpponent();
        }

        board.displayResult();
    }

}
