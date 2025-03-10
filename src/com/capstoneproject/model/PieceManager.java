package com.capstoneproject.model;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.model.piece.Piece;
import java.util.List;
import java.util.Map;

/**
 * Manages chess pieces, ensuring they are mapped to the sorted list
 * and moved dynamically on the board.
 */
public class PieceManager {

    private final Map<Integer, Piece> pieceMapping;

    /**
     * Creates a new PieceManager instance.
     *
     * @param color The color of the pieces.
     * @param pieceQuantity The number of pieces to initialize.
     */
    public PieceManager(PieceColor color, int pieceQuantity) {
        this.pieceMapping = PieceFactory.createPieces(color, pieceQuantity);
    }

    /**
     * Converts the ordered list into an array of chess pieces.
     *
     * @param values The ordered list representing piece positions.
     * @return An array of corresponding Piece instances.
     * @throws IllegalArgumentException if a piece index is invalid.
     */
    public Piece[] convertListToPieces(List<?> values) {
        Piece[] pieces = new Piece[values.size()];
        for (int i = 0; i < values.size(); i++) {
            int pieceIndex = convertValueToIntIndex(values.get(i));
            Piece piece = getPiece(pieceIndex);
            if (piece == null) {
                throw new IllegalArgumentException("No piece found for index: " + pieceIndex);
            }
            pieces[i] = piece;
        }
        return pieces;
    }

    /**
     * Retrieves a chess piece based on its assigned index.
     *
     * @param index The index representing a piece.
     * @return The corresponding Piece instance.
     */
    public Piece getPiece(int index) {
        return pieceMapping.get(index);
    }

    /**
     * Converts an object value to an integer representing a chess piece index.
     *
     * @param value The input value.
     * @return The corresponding integer index.
     * @throws IllegalArgumentException if the value is not a valid Integer or Character.
     */
    private int convertValueToIntIndex(Object value) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof Character) {
            int index = (Character) value - 'a' + 1;
            if (index <= 0) {
                throw new IllegalArgumentException("Invalid character value: " + value);
            }
            return index;
        }
        throw new IllegalArgumentException("Invalid piece value: " + value + ". Expected Integer or Character.");
    }

}