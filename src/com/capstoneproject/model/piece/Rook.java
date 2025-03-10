package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Represents a Rook chess piece.
 */
public class Rook extends Piece {

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK);
    }

}