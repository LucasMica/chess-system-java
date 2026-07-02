package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;

import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch ch = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen();
                UI.printBoard(ch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMovies = ch.possibleMovies(source);
                UI.clearScreen();
                UI.printBoard(ch.getPieces(), possibleMovies);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = ch.performChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
