package application;

import boardgame.Position;
import chess.ChessMatch;

import java.util.Arrays;

public class app {
    public static void main(String[] args) {

        ChessMatch ch = new ChessMatch();
        UI.printBoard(ch.getPieces());
    }
}
