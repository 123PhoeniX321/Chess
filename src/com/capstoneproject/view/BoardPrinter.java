package com.capstoneproject.view;

import com.capstoneproject.model.piece.Piece;

/**
 * Utility class for printing the chessboard to the console.
 */
public class BoardPrinter {

    private BoardPrinter() {
    }

    /**
     * Prints the current state of the chessboard
     *
     * @param board The chessboard matrix containing pieces.
     */
    public static void printBoard(Piece[][] board) {
        final String BLACK_SQUARE = "▮";
        final String WHITE_SQUARE = "▭";
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                boolean isBlackSquare = (row + col) % 2 != 0;
                String squareSymbol = isBlackSquare ? BLACK_SQUARE : WHITE_SQUARE;
                if (piece != null) {
                    System.out.print(" " + piece.getSymbol());
                } else {
                    System.out.print(" " + squareSymbol);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}