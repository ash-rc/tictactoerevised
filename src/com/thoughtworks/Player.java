package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ashleycampo on 6/21/14.
 */

public class Player {
    private String symbol;
    private int player;
    private BufferedReader reader;
    private Board board;
    private Player opponent;
    private PrintStream out;

    public Player(BufferedReader reader, String symbol, Board board, PrintStream out, int player) {
        this.reader = reader;
        this.symbol = symbol;
        this.board = board;
        this.player = player;
        this.out = out;
    }

    public void getMove() throws IOException {
        int move = requestMove();
        Boolean movePlacedSuccessfully = board.placeMove(symbol, move-1);
        while(!movePlacedSuccessfully) {
            move = requestMove();
            movePlacedSuccessfully = board.placeMove(symbol, move-1);
        }
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
        System.out.println(opponent.getSymbol());
    }

    public Player getOpponent() {
        return opponent;
    }

    public String getSymbol() {
        return symbol;
    }

    private int requestMove() throws IOException {
        out.println("Player " + player + " make a move: ");
        return Integer.parseInt(reader.readLine());
    }
}
