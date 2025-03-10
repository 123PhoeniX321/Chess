package com.capstoneproject.model.piece;

import com.capstoneproject.enums.PieceColor;
import com.capstoneproject.enums.PieceType;

/**
 * Abstract base class for all chess pieces.
 */
public abstract class Piece {

    protected final PieceColor color;
    protected final PieceType type;
    protected final String symbol;

    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
        this.symbol = type.getSymbol(color);
    }

    public PieceColor getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

}