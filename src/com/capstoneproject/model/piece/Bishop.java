package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Represents a Bishop chess piece.
 */
public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
    }

}