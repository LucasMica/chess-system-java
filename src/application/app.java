package application;

import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Arrays;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch ch = new ChessMatch();

        while(true) {
            UI.printBoard(ch.getPieces());
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessPosition(sc);

            System.out.println();
            System.out.println("Target: ");
            ChessPosition target = UI.readChessPosition(sc);


            ChessPiece capturedPiece = ch.performChessMove(source, target);
        }
    }
}
