package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Represents a Pawn chess piece.
 */
public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN);
    }

}