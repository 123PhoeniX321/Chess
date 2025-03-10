package com.capstoneproject.enums;

/**
 * Enumeration representing the different chess pieces and their symbols.
 */
public enum PieceType {

    KING("♔", "♚"),
    QUEEN("♕", "♛"),
    ROOK("♖", "♜"),
    BISHOP("♗", "♝"),
    KNIGHT("♘", "♞"),
    PAWN("♙", "♟");

    private final String whiteSymbol;
    private final String blackSymbol;

    PieceType(String whiteSymbol, String blackSymbol) {
        this.whiteSymbol = whiteSymbol;
        this.blackSymbol = blackSymbol;
    }

    public String getSymbol(PieceColor color) {
        return (color == PieceColor.WHITE) ? whiteSymbol : blackSymbol;
    }
}
