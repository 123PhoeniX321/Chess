package com.capstoneproject.model.board;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.model.piece.Piece;
import com.capstoneproject.utils.BoardUtils;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Arrays;

/**
 * Represents the chessboard, managing the placement and organization of pieces.
 * This class is responsible for updating and maintaining the board state.
 */
public class ChessBoard {

    private final Piece[][] board = new Piece[8][8];

    /**
     * Predefined positions for placing pieces on the board.
     * The first row contains major pieces, and the second row contains pawns.
     */
    private static final int[][] BOARD_POSITIONS_PIECES = {
            {8, 6, 4, 2, 1, 3, 5, 7},
            {9, 10, 11, 12, 13, 14, 15, 16}
    };

    /**
     * Updates the chessboard state based on the phase of sorting.
     *
     * @param sortedPieces The array of chess pieces.
     * @param isInitial If true, places pieces randomly; otherwise, assigns them to mapped positions.
     */
    public void updateBoard(Piece[] sortedPieces, boolean isInitial) {
        validatePieces(sortedPieces);
        PieceColor color = sortedPieces[0].getColor();
        clearBoard();
        if (isInitial) {
            placePiecesRandomly(sortedPieces);
        } else {
            assignPiecesToBoard(sortedPieces, color);
        }
    }

    /**
     * Validates the sorted pieces array before updating the board.
     *
     * @param sortedPieces The array of chess pieces to validate.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    private void validatePieces(Piece[] sortedPieces) {
        if (sortedPieces == null || sortedPieces.length == 0) {
            throw new IllegalArgumentException("The sorted pieces array cannot be null or empty.");
        }
    }

    /**
     * Places the given sorted pieces onto the board based on their assigned positions.
     *
     * @param sortedPieces The array of sorted chess pieces.
     * @param color The color of the pieces being placed.
     */
    private void assignPiecesToBoard(Piece[] sortedPieces, PieceColor color) {
        for (int i = 0; i < sortedPieces.length; i++) {
            int[] position = findBoardPosition(i);
            if (BoardUtils.isValidPosition(position)) {
                board[getTargetRow(position[0], color)][position[1]] = sortedPieces[i];
            }
        }
    }

    /**
     * Finds the position of a piece on the predefined board layout.
     *
     * @param value The index of the piece.
     * @return The row and column coordinates as an array, or NOT_FOUND if not found.
     */
    private int[] findBoardPosition(int value) {
        for (int row = 0; row < BOARD_POSITIONS_PIECES.length; row++) {
            for (int col = 0; col < BOARD_POSITIONS_PIECES[row].length; col++) {
                if (BOARD_POSITIONS_PIECES[row][col] == value + 1) {
                    return new int[]{row, col};
                }
            }
        }
        return BoardUtils.POSITION_NOT_FOUND;
    }

    /**
     * Determines the target row for placing a piece based on its color.
     *
     * @param row The initial row position.
     * @param color The color of the piece.
     * @return The adjusted row position based on the piece's color.
     */
    private int getTargetRow(int row, PieceColor color) {
        return (color == PieceColor.WHITE) ? (7 - row) : row;
    }

    /**
     * Clears the board by setting all positions to null.
     */
    private void clearBoard() {
        for (Piece[] pieces : board) {
            Arrays.fill(pieces, null);
        }
    }

    /**
     * Returns the current state of the chessboard.
     *
     * @return A 2D array representing the board with chess pieces.
     */
    public Piece[][] getBoardMatrix() {
        return board;
    }

    /**
     * Places pieces randomly on the board without overlapping.
     *
     * @param sortedPieces The array of chess pieces to be placed randomly.
     */
    public void placePiecesRandomly(Piece[] sortedPieces) {
        clearBoard();
        Random random = new Random();
        Set<String> usedPositions = new HashSet<>();
        for (Piece piece : sortedPieces) {
            int row, col;
            do {
                row = random.nextInt(8);
                col = random.nextInt(8);
            } while (usedPositions.contains(row + "," + col));
            board[row][col] = piece;
            usedPositions.add(row + "," + col);
        }
    }

}