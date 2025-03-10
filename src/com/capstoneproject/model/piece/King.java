package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Represents a King chess piece.
 */
public class King extends Piece {

    public King(PieceColor color) {
        super(color, PieceType.KING);
    }

}