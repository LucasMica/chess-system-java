package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch cm;

    public King(Board board, Color color, ChessMatch cm) {
        super(board, color);
        this.cm = cm;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null
                && p instanceof Rook
                && p.getColor() == getColor()
                && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMovie(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //special movie castling
        if(getMoveCount() == 0 && !cm.getCheck()) {
           //kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            //queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if(getBoard().piece(p1) == null
                        && getBoard().piece(p2) == null
                        && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
        }

        return mat;
    }

    private boolean canMovie(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);

        return p == null || p.getColor() != getColor();
    }



}
