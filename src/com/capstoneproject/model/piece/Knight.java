package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Represents a Knight chess piece.
 */
public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color, PieceType.KNIGHT);
    }

}