package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ashleycampo on 6/21/14.
 */
public class Player {
    private String symbol;
    private int player;
    private BufferedReader reader;
    private Board board;
    private Player opponent;

    public Player(BufferedReader reader, String symbol, Board board, int player) {
        this.reader = reader;
        this.symbol = symbol;
        this.board = board;
        this.player = player;
    }

    public void getMove() throws IOException {
        int move = requestMove();
        Boolean movePlacedSuccessfully = board.placeMove(symbol, move-1);
        while(movePlacedSuccessfully) {
            move = requestMove();
            movePlacedSuccessfully = board.placeMove(symbol, move-1);
        }
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }

    private int requestMove() throws IOException {
        System.out.println("Player " + player + " make a move: ");
        return Integer.parseInt(reader.readLine());
    }
}
